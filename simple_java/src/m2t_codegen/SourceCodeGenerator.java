package m2t_codegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import simpleJava.Packet;

public class SourceCodeGenerator {

	public static void main(String[] args) {
		// Register the XMI resource factory for the .simplejava extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("simplejava", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSetImpl resSet = new ResourceSetImpl();

		// Get the resource
		Resource resource = resSet.getResource(URI.createURI("path/to/your/model.simplejava"), true);

		// Load the contents of the resource
		EObject root = resource.getContents().get(0);

		// Generate Java code from the model
		generateJavaCode(root);
	}

	public static void generateJavaCode(Packet p) {
		// navigieren mit ECore-Hilfmitteln, nicht mit Packet.getInterfaces() und
		// Packet.getClasses()
		for (EObject child : p.eContents()) {
			generateJavaCode(child);
		}
	}

	private static void generateJavaCode(EObject o) {
		if (o instanceof simpleJava.Class) {
			generateClassCode((simpleJava.Class) o);
		} else if (o instanceof simpleJava.Interface) {
			generateInterfaceCode((simpleJava.Interface) o);
		} else {
			throw new RuntimeException("Cannot handle: " + o);
		}

	}

	private static void generateClassCode(simpleJava.Class clazz) {
		StringBuilder code = new StringBuilder();

		code.append("public class ").append(clazz.getName());
		if (clazz.getSuperClass() != null) {
			code.append(" extends ").append(clazz.getSuperClass().getName());
		}
		code.append(" {\n");

		for (simpleJava.Field field : clazz.getFields()) {
			code.append("    private ").append(field.getType()).append(" ").append(field.getName()).append(";\n");
		}

		for (simpleJava.Method method : clazz.getMethods()) {
			code.append("    public ").append(method.getReturnType()).append(" ").append(method.getName()).append("(");
			EList<simpleJava.Parameter> parameters = method.getParameters();
			for (int i = 0; i < parameters.size(); i++) {
				simpleJava.Parameter param = parameters.get(i);
				code.append(param.getType()).append(" ").append(param.getName());
				if (i < parameters.size() - 1) {
					code.append(", ");
				}
			}
			code.append(") {\n");
			code.append("        // TODO: Implement method\n");
			code.append("    }\n");
		}

		code.append("}\n");

		System.out.println("-------------------");
		System.out.println("Class: " + clazz.getName());
		System.out.println(code.toString());
		System.out.println("-------------------");
		
		// saveToFile(clazz.getName() + ".java", code.toString());
	}

	private static void generateInterfaceCode(simpleJava.Interface interf) {
		StringBuilder code = new StringBuilder();

		code.append("public interface ").append(interf.getName()).append(" {\n");

		for (simpleJava.Method method : interf.getMethods()) {
			code.append("    ").append(method.getReturnType()).append(" ").append(method.getName()).append("(");
			EList<simpleJava.Parameter> parameters = method.getParameters();
			for (int i = 0; i < parameters.size(); i++) {
				simpleJava.Parameter param = parameters.get(i);
				code.append(param.getType()).append(" ").append(param.getName());
				if (i < parameters.size() - 1) {
					code.append(", ");
				}
			}
			code.append(");\n");
		}

		code.append("}\n");

		saveToFile(interf.getName() + ".java", code.toString());
	}

	private static void saveToFile(String fileName, String content) {
		try (FileWriter fileWriter = new FileWriter(new File(fileName))) {
			fileWriter.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}