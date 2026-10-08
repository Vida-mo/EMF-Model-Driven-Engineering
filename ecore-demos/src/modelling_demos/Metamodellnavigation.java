package modelling_demos;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import event_modeling_metamodel.Slice;

public class Metamodellnavigation {

	/**
	 * Spezifisch für {@link Slice}-Instanz.
	 * 
	 * @param o Die {@link Organization}
	 */
	public static void printMetamodelInfo(final Slice s) {
		printMetamodelInfo((EObject) s);
	}
	
	/**
	 * Generisch für {@link EObject}-Instanz.
	 * 
	 * @param o Die {@link Organization}
	 */
	public static void printMetamodelInfo(final EObject o) {
		printMetamodelInfo(o.eClass());
		printEObjectGenerisch(o);
		printEObjectGenerisch(o.eClass());
	}

	/**
	 * Generisch für {@link EClass}-Instanz.
	 * 
	 * @param o Die {@link Organization}
	 */
	public static void printMetamodelInfo(final EClass c) {
		System.out.println("EClass " + c.getName());
		System.out.println("\tDirekte Supertypen: " + c.getESuperTypes());
		System.out.println("\tAlle Supertypen: " + c.getEAllSuperTypes());

		System.out.println("\tAttribtute: " + c.getEAttributes());
		System.out.println("\tReferenzen: " + c.getEReferences());
		for (EStructuralFeature f : c.getEStructuralFeatures()) {
			printEStructuralFeature(f);
		}
	}

	private static void printEStructuralFeature(final EStructuralFeature f) {
		if (f instanceof EAttribute) {
			printEAttribute((EAttribute) f);
		} else if (f instanceof EReference) {
			printEReference((EReference) f);
		} else {
			throw new IllegalArgumentException("Cannot handle: " + f);
		}
	}

	private static void printEAttribute(final EAttribute a) {
		System.out.println("EAttribut " + a.getName());
		System.out.println("\tTyp: " + a.getEAttributeType());
		System.out.println("\tlower bound: " + a.getLowerBound());
		System.out.println("\tupper bound: " + a.getUpperBound());
		System.out.println("\tDefault-Wert: " + a.getDefaultValueLiteral());
		System.out.println("\tBesitzer/Container: " + a.eContainer());
	}

	/** Sprung zum Meta-Meta-Modell */
	private static void printEAttributeGenerisch(final EAttribute a) {
		printEObjectGenerisch(a);
	}

	/** Sprung zum Meta-Meta-Modell */
	private static void printEObjectGenerisch(final EObject o) {
		final EClass c = o.eClass();
		System.out.println("EObject " + o + " ist vom Typ " + c.getName());
		System.out.println("\tEs hat folgende strukturelle Eigenschaften:");
		for (EStructuralFeature f : c.getEAllStructuralFeatures()) {
			printEStructuralFeature(f);
		}
	}

	private static void printEReference(final EReference r) {
		System.out.println("EReference " + r.getName());
		System.out.println("\tTyp: " + r.getEType());
		System.out.println("\tlower bound: " + r.getLowerBound());
		System.out.println("\tupper bound: " + r.getUpperBound());
		System.out.println("\tBesitzer/Container: " + r.eContainer());
	}

}
