package k3transfofootprint;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import k3transfofootprint.K3TransfoFootprint;
import k3transfofootprint.orgeclipsextextxbaseXCollectionLiteralAspect;
import k3transfofootprint.orgeclipsextextxbaseXSetLiteralAspectXSetLiteralAspectProperties;
import org.eclipse.xtext.xbase.XSetLiteral;

@Aspect(className = XSetLiteral.class, with = { orgeclipsextextxbaseXCollectionLiteralAspect.class })
@SuppressWarnings("all")
public class orgeclipsextextxbaseXSetLiteralAspect extends orgeclipsextextxbaseXCollectionLiteralAspect {
  @OverrideAspectMethod
  public static void _visitToAddClasses(final XSetLiteral _self, final K3TransfoFootprint theSlicer) {
    _self_ = k3transfofootprint.orgeclipsextextxbaseXSetLiteralAspectXSetLiteralAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.eclipse.xtext.xbase.XSetLiteral){
    	      k3transfofootprint.orgeclipsextextxbaseXSetLiteralAspect._privk3__visitToAddClasses((org.eclipse.xtext.xbase.XSetLiteral)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.xbase.XCollectionLiteral){
    	      k3transfofootprint.orgeclipsextextxbaseXCollectionLiteralAspect._privk3__visitToAddClasses((org.eclipse.xtext.xbase.XCollectionLiteral)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.xbase.XExpression){
    	      k3transfofootprint.orgeclipsextextxbaseXExpressionAspect._privk3__visitToAddClasses((org.eclipse.xtext.xbase.XExpression)_self,theSlicer);
    	     } else  if (_self instanceof java.lang.Object){
    	      k3transfofootprint.__SlicerAspect__._privk3__visitToAddClasses((java.lang.Object)_self,theSlicer);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  @OverrideAspectMethod
  public static void _visitToAddRelations(final XSetLiteral _self, final K3TransfoFootprint theSlicer) {
    _self_ = k3transfofootprint.orgeclipsextextxbaseXSetLiteralAspectXSetLiteralAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.eclipse.xtext.xbase.XSetLiteral){
    	      k3transfofootprint.orgeclipsextextxbaseXSetLiteralAspect._privk3__visitToAddRelations((org.eclipse.xtext.xbase.XSetLiteral)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.xbase.XCollectionLiteral){
    	      k3transfofootprint.orgeclipsextextxbaseXCollectionLiteralAspect._privk3__visitToAddRelations((org.eclipse.xtext.xbase.XCollectionLiteral)_self,theSlicer);
    	     } else  if (_self instanceof org.eclipse.xtext.xbase.XExpression){
    	      k3transfofootprint.orgeclipsextextxbaseXExpressionAspect._privk3__visitToAddRelations((org.eclipse.xtext.xbase.XExpression)_self,theSlicer);
    	     } else  if (_self instanceof java.lang.Object){
    	      k3transfofootprint.__SlicerAspect__._privk3__visitToAddRelations((java.lang.Object)_self,theSlicer);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  public static orgeclipsextextxbaseXSetLiteralAspectXSetLiteralAspectProperties _self_;
  
  private static void super__visitToAddClasses(final XSetLiteral _self, final K3TransfoFootprint theSlicer) {
     k3transfofootprint.orgeclipsextextxbaseXCollectionLiteralAspect._privk3__visitToAddClasses(_self,theSlicer);
  }
  
  protected static void _privk3__visitToAddClasses(final XSetLiteral _self, final K3TransfoFootprint theSlicer) {
    orgeclipsextextxbaseXSetLiteralAspect.super__visitToAddClasses(_self, theSlicer);
  }
  
  private static void super__visitToAddRelations(final XSetLiteral _self, final K3TransfoFootprint theSlicer) {
     k3transfofootprint.orgeclipsextextxbaseXCollectionLiteralAspect._privk3__visitToAddRelations(_self,theSlicer);
  }
  
  protected static void _privk3__visitToAddRelations(final XSetLiteral _self, final K3TransfoFootprint theSlicer) {
    orgeclipsextextxbaseXSetLiteralAspect.super__visitToAddRelations(_self, theSlicer);
  }
}