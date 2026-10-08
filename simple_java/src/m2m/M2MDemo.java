package m2m;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import event_modeling_metamodel.Command;
import event_modeling_metamodel.Event_modeling_metamodelPackage;
import event_modeling_metamodel.Slice;
import m2t_codegen.SourceCodeGenerator;
import simpleJava.Class;
import simpleJava.Packet;
import simpleJava.SimpleJavaFactory;

public class M2MDemo {
	public static void main(String[] args) {
		final Slice sourceModel = ladeEventModelingModell("demo.eventmodelingmodel");
		
		// M2M-Trafo
		final Packet targetModel = transformModel(sourceModel);
		
		// M2T-Trafo
		SourceCodeGenerator.generateJavaCode(targetModel);
	}

	public static Packet transformModel(Slice s) {
		final Packet p = SimpleJavaFactory.eINSTANCE.createPacket();
		p.setName(s.getName());

		for (Command c : s.getCommands()) {
			final Class clazz = transformCommand(c);
			p.getClasses().add(clazz);
		}

		return p;
	}

	private static simpleJava.Class transformCommand(Command c) {
		simpleJava.Class clazz = SimpleJavaFactory.eINSTANCE.createClass();

		clazz.setName(c.getTitle());

		return clazz;
	}

	private static Slice ladeEventModelingModell(String pfad) {
		// Initialize the model
		Event_modeling_metamodelPackage.eINSTANCE.eClass();

		// Register the XMI resource factory for the extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("eventmodelingmodel", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the resource
		Resource resource = resSet.getResource(URI.createURI(pfad), true);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		Slice modelRoot = (Slice) resource.getContents().get(0);
		return modelRoot;
	}
}
