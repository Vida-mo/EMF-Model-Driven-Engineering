package event_modeling_code_generator;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import event_modeling_metamodel.Command;
import event_modeling_metamodel.Event_modeling_metamodelFactory;
import event_modeling_metamodel.Event_modeling_metamodelPackage;
import event_modeling_metamodel.Slice;

public class CodeGen {
	public static void main(String[] args) {
		final Slice demoSlice = erstelleDemomodell();
		speichereModell(demoSlice);
		
		generiereJavaCode(demoSlice);
	}

	static Slice erstelleDemomodell() {
		// Initialize the model
		Event_modeling_metamodelPackage.eINSTANCE.eClass();

		Slice demoSlice = Event_modeling_metamodelFactory.eINSTANCE.createSlice();
		demoSlice.setId("123");
		demoSlice.setName("Demo Slice");

		{
			Command c = Event_modeling_metamodelFactory.eINSTANCE.createCommand();
			demoSlice.getCommands().add(c);
			c.setId("c1");
			c.setTitle("Command 1");
		}

		{
			Command c = Event_modeling_metamodelFactory.eINSTANCE.createCommand();
			demoSlice.getCommands().add(c);
			c.setId("c2");
			c.setTitle("Command 2");
		}

		return demoSlice;
	}
	
	private static void generiereJavaCode(Slice slice) {
		
	}


	private static void speichereModell(Slice demoSlice) {
		// Register the XMI resource factory for the .eventmodelingmodel extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("eventmodelingmodel", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// create a resource
		Resource resource = resSet.createResource(URI.createURI("/tmp/demo.eventmodelingmodel"));
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		resource.getContents().add(demoSlice);

		// save the content
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
