package fr.inria.diverse.melange.processors

import fr.inria.diverse.melange.ast.ASTHelper
import fr.inria.diverse.melange.ast.MetamodelExtensions
import fr.inria.diverse.melange.ast.ModelTypeExtensions
import fr.inria.diverse.melange.ast.NamingHelper
import fr.inria.diverse.melange.eclipse.EclipseProjectHelper
import fr.inria.diverse.melange.metamodel.melange.ModelTypingSpace
import javax.inject.Inject
import org.apache.log4j.Logger
import org.eclipse.core.runtime.CoreException
import org.eclipse.pde.internal.core.PDECore
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel
import org.eclipse.pde.internal.core.project.PDEProject
import org.eclipse.xtext.naming.IQualifiedNameProvider

/**
 * For each model type, create a new fr.inria.diverse.melange.modeltype
 * contribution in plugin.xml.
 * For each language, create a new fr.inria.diverse.melange.language
 * contribution in plugin.xml, with the list of adapters towards
 * implemented model types.
 */
class ExtensionPointProcessor extends DispatchMelangeProcessor
{
	@Inject extension NamingHelper
	@Inject extension MetamodelExtensions
	@Inject extension ModelTypeExtensions
	@Inject extension ASTHelper
	@Inject extension EclipseProjectHelper
	@Inject extension IQualifiedNameProvider

	private static Logger log = Logger::getLogger(ExtensionPointProcessor)

	private static final String MELANGE_RESOURCE_PLUGIN = "fr.inria.diverse.melange.resource"
	private static final String LANGUAGE_EXTENSION_POINT = "fr.inria.diverse.melange.language"
	private static final String MODELTYPE_EXTENSION_POINT = "fr.inria.diverse.melange.modeltype"

	def dispatch void preProcess(ModelTypingSpace root) {
		val project = root.eResource.project

		if (project !== null) {
			val pluginXml = PDEProject::getPluginXml(project)
			val pluginModel = PDECore::getDefault.modelManager.findModel(project)
			val fModel = new WorkspacePluginModel(pluginXml, false)
			val pluginBase = fModel.pluginBase
			val melangeResourcePlugin = PDECore::getDefault.modelManager.allModels.findFirst[
				bundleDescription.name == MELANGE_RESOURCE_PLUGIN
			]
			val languageExtensionPoint = melangeResourcePlugin.extensions.extensionPoints.findFirst[
				fullId == LANGUAGE_EXTENSION_POINT
			]
			val modeltypeExtensionPoint = melangeResourcePlugin.extensions.extensionPoints.findFirst[
				fullId == MODELTYPE_EXTENSION_POINT
			]

			fModel.editable = true
			fModel.load

			if (pluginModel !== null && pluginBase !== null) {
				val modelTypes = root.modelTypes.filter[isComplete]
				val metamodels = root.metamodels.filter[isComplete]

				if (modelTypes.size > 0 && modeltypeExtensionPoint !== null) {
					val newExtension = fModel.factory.createExtension => [
						point = modeltypeExtensionPoint.id
					]

					modelTypes.forEach[mt |
						try {
							val fqn = mt.fullyQualifiedName.toString
							val modeltypeElement = fModel.factory.createElement(newExtension)
							modeltypeElement.name = "modeltype"
							modeltypeElement.setAttribute("id", fqn)
							modeltypeElement.setAttribute("uri", mt.uri)
//							modeltypeElement.setAttribute("description", "...")
							newExtension.add(modeltypeElement)
							if (!newExtension.isInTheModel) {
								fModel.extensions.add(newExtension)
								log.debug('''Registered new modeltype contribution <«fqn», «mt.uri»> in plugin.xml''')
							}
						} catch (CoreException e) {
							log.debug('''Failed to register new model type contribution''', e)
						}
					]
				}

				if (metamodels.size > 0 && languageExtensionPoint !== null) {
					val newExtension = fModel.factory.createExtension => [
						point = languageExtensionPoint.id
					]

					metamodels.forEach[mm |
						try {
							val fqn = mm.fullyQualifiedName.toString
							val languageElement = fModel.factory.createElement(newExtension)
							languageElement.name = "language"
							languageElement.setAttribute("id", fqn)
							languageElement.setAttribute("exactType", mm.exactType.fullyQualifiedName.toString)
//							modeltypeElement.setAttribute("description", "...")

							// Register adapters
							mm.implements.forEach[mt |
								val resourceAdapterName = mm.adapterNameFor(mt)
								val adapterElement = fModel.factory.createElement(languageElement)
								adapterElement.name = "adapter"
								adapterElement.setAttribute("modeltypeId", mt.fullyQualifiedName.toString)
								adapterElement.setAttribute("class", resourceAdapterName)
								languageElement.add(adapterElement)
							]

							newExtension.add(languageElement)
							if (!newExtension.isInTheModel) {
								fModel.extensions.add(newExtension)
								log.debug('''Registered new language contribution <«fqn»> in plugin.xml''')
							}
						} catch (CoreException e) {
							log.debug('''Failed to register language contribution''', e)
						}
					]
				}
			}

			fModel.save
		}
	}
}