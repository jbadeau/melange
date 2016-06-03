package fr.inria.diverse.melanger.melangedlang.adapters.melangedlangmt.minifsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import fr.inria.diverse.melanger.melangedlang.adapters.melangedlangmt.MelangedLangMTAdaptersFactory;
import fr.inria.diverse.melanger.melangedlang.minifsm.BooleanOperation;
import fr.inria.diverse.melanger.melangedlangmt.minifsm.BooleanExpression;
import fr.inria.diverse.melanger.melangedlangmt.minifsm.Context;
import org.eclipse.emf.ecore.EClass;

@SuppressWarnings("all")
public class BooleanOperationAdapter extends EObjectAdapter<BooleanOperation> implements fr.inria.diverse.melanger.melangedlangmt.minifsm.BooleanOperation {
  private MelangedLangMTAdaptersFactory adaptersFactory;
  
  public BooleanOperationAdapter() {
    super(fr.inria.diverse.melanger.melangedlang.adapters.melangedlangmt.MelangedLangMTAdaptersFactory.getInstance());
    adaptersFactory = fr.inria.diverse.melanger.melangedlang.adapters.melangedlangmt.MelangedLangMTAdaptersFactory.getInstance();
  }
  
  @Override
  public BooleanExpression getLeft() {
    return (BooleanExpression) adaptersFactory.createAdapter(adaptee.getLeft(), eResource);
  }
  
  @Override
  public void setLeft(final BooleanExpression o) {
    if (o != null)
    	adaptee.setLeft(((fr.inria.diverse.melanger.melangedlang.adapters.melangedlangmt.minifsm.BooleanExpressionAdapter) o).getAdaptee());
    else adaptee.setLeft(null);
  }
  
  @Override
  public BooleanExpression getRight() {
    return (BooleanExpression) adaptersFactory.createAdapter(adaptee.getRight(), eResource);
  }
  
  @Override
  public void setRight(final BooleanExpression o) {
    if (o != null)
    	adaptee.setRight(((fr.inria.diverse.melanger.melangedlang.adapters.melangedlangmt.minifsm.BooleanExpressionAdapter) o).getAdaptee());
    else adaptee.setRight(null);
  }
  
  @Override
  public boolean eval(final Context ctx) {
    return fr.inria.diverse.melanger.melangedlang.aspects.BooleanExpressionAspect.eval(adaptee, ((fr.inria.diverse.melanger.melangedlang.adapters.melangedlangmt.minifsm.ContextAdapter) ctx).getAdaptee()
    );
  }
  
  @Override
  public EClass eClass() {
    return fr.inria.diverse.melanger.melangedlangmt.minifsm.MinifsmPackage.eINSTANCE.getBooleanOperation();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case fr.inria.diverse.melanger.melangedlangmt.minifsm.MinifsmPackage.BOOLEAN_OPERATION__LEFT:
    		return getLeft();
    	case fr.inria.diverse.melanger.melangedlangmt.minifsm.MinifsmPackage.BOOLEAN_OPERATION__RIGHT:
    		return getRight();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case fr.inria.diverse.melanger.melangedlangmt.minifsm.MinifsmPackage.BOOLEAN_OPERATION__LEFT:
    		return getLeft() != null;
    	case fr.inria.diverse.melanger.melangedlangmt.minifsm.MinifsmPackage.BOOLEAN_OPERATION__RIGHT:
    		return getRight() != null;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case fr.inria.diverse.melanger.melangedlangmt.minifsm.MinifsmPackage.BOOLEAN_OPERATION__LEFT:
    		setLeft(
    		(fr.inria.diverse.melanger.melangedlangmt.minifsm.BooleanExpression)
    		 newValue);
    		return;
    	case fr.inria.diverse.melanger.melangedlangmt.minifsm.MinifsmPackage.BOOLEAN_OPERATION__RIGHT:
    		setRight(
    		(fr.inria.diverse.melanger.melangedlangmt.minifsm.BooleanExpression)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
