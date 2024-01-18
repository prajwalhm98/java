package com.example.UnitTest;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

public class TestGeneration {

	static String INPUT_FILE = "C:\\Users\\241359\\Documents\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\UnitTesting.txt";
	static String OUTPUT_DIRECTORY = "C:\\Users\\241359\\Documents\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\UnitTesting\\src\\test\\java\\com\\example\\UnitTest";

	public void generateTestCases(String basePackage) {
		String reflectionsOutputFile = INPUT_FILE;
		scanAndSaveReflectionsData(basePackage, reflectionsOutputFile);
		// generateTestCasesFromReflectionsData(reflectionsOutputFile);
		generateServiceTestCasesFromReflectionsData(reflectionsOutputFile);

	}

	private void generateServiceTestCasesFromReflectionsData(String reflectionsOutputFile) {
		try {
			File file = new File(reflectionsOutputFile);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.startsWith("Class: ")) {
					String className = line.substring(7);
					Class<?> targetClass = Class.forName(className);
					if (isServiceClass(targetClass)) {
						generateServiceTestCases(targetClass);
					}
				}
			}
			scanner.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	

	private void generateServiceTestCases(Class<?> targetClass) {
		StringBuilder testCaseBuilder = new StringBuilder();
		testCaseBuilder.append("package com.example.UnitTest;\n");
		generateImports(targetClass, testCaseBuilder);
		testCaseBuilder.append("@SpringBootTest\n");
		testCaseBuilder.append("public class ").append(targetClass.getSimpleName()).append("TestCase {\n\n");
		testCaseBuilder.append("@Mock\n");
		Field[] fields = targetClass.getDeclaredFields();
		for (Field field : fields) {
			Class<?> fieldType = field.getType();
			String fieldName = field.getName();
			testCaseBuilder.append("private ").append(fieldType.getSimpleName());
			testCaseBuilder.append(" ").append(fieldName).append(";\n");
		}
		testCaseBuilder.append("@InjectMocks\n");
		testCaseBuilder.append("private ").append(targetClass.getSimpleName());
		testCaseBuilder.append(" ").append(targetClass.getSimpleName().toLowerCase()).append(";\n");
		testCaseBuilder.append("\n");
        
		testCaseBuilder.append("@BeforeEach\n");
		testCaseBuilder.append("public void setUp() { \n");
		testCaseBuilder.append(targetClass.getSimpleName().toLowerCase()
				+"= new " + targetClass.getSimpleName()+"();\n");
		testCaseBuilder.append("}\n");
		testCaseBuilder.append("\n");
		Method[] methods = targetClass.getDeclaredMethods();
		for (Method method : methods) {
			if (isServiceMethod(method)) {
				generateServiceMethodTestCase(targetClass, method, testCaseBuilder);
			}
		}

		testCaseBuilder.append("}\n");

		String outputFilePath = OUTPUT_DIRECTORY + File.separator + targetClass.getSimpleName() + "TestCase.java";
		try (PrintWriter writer = new PrintWriter(outputFilePath)) {
			writer.write(testCaseBuilder.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private boolean isServiceMethod(Method method) {
		String methodName = method.getName().toLowerCase();

		return methodName.startsWith("create") || methodName.startsWith("update") || methodName.startsWith("delete")
				|| methodName.startsWith("get") || methodName.startsWith("find");
	}

	private void generateServiceMethodTestCase(Class<?> targetClass, Method method, StringBuilder testCaseBuilder) {
		String methodName = method.getName();
        Class<?> returnType = method.getReturnType();

        testCaseBuilder.append("@Test\n");
        testCaseBuilder.append("public void test").append((methodName)).append("() {\n");

        testCaseBuilder.append("    // Arrange\n");
        generateRepositoryMockSetup(testCaseBuilder, returnType);
	    
	    testCaseBuilder.append("    // Act\n");
	    testCaseBuilder.append("\n");
	  	   
	

	    testCaseBuilder.append("    // Assert\n");
	   
	        testCaseBuilder.append("    Assertions.assertNotNull(employee);\n");
	    

	    testCaseBuilder.append("}\n\n");
	}
	
	private void generateRepositoryMockSetup(StringBuilder testCaseBuilder, Class<?> fieldType) {
	   
	    String repoName = "employeeRepository"; 
	    String listName = "employee";  
	    testCaseBuilder.append("List<EmployeeModel> ").append(listName).append(" = new ArrayList<>();\n");
	    testCaseBuilder.append("when(").append(repoName).append(".findAll()).thenReturn(").append(listName).append(");\n");

	}

//	private String capitalize(String methodName) {
//		if (methodName == null || methodName.isEmpty()) {
//			return methodName;
//		}
//		return Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1);
//	}

	
	private boolean isServiceClass(Class<?> targetClass) {
	    
	    return targetClass.getSimpleName().endsWith("Service");
	}

	private void scanAndSaveReflectionsData(String basePackage, String outputFile) {
		try {
			Reflections reflections = new Reflections(basePackage, new SubTypesScanner(false));
			Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
			FileOutputStream fos = new FileOutputStream(outputFile);
			PrintStream ps = new PrintStream(fos);

			System.setOut(ps);
			for (Class<?> targetClass : classes) {
				generateReflectionsData(targetClass);
			}

			ps.close();
			fos.close();

			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    

	private void generateReflectionsData(Class<?> targetClass) {

		System.out.println("Class: " + targetClass.getName());

		if (targetClass.isArray()) {
			Class<?> componentType = targetClass.getComponentType();
			System.out.println("Array Component Type: " + componentType.getName());
		}

		Constructor<?>[] constructors = targetClass.getDeclaredConstructors();
		System.out.println("Constructors:");
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}

		Field[] fields = targetClass.getDeclaredFields();
		System.out.println("Fields:");
		for (Field field : fields) {
			System.out.println(field);
		}

		Method[] methods = targetClass.getDeclaredMethods();
		System.out.println("Methods:");
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("_______________________");

	}

//	private void generateTestCasesFromReflectionsData(String reflectionsOutputFile) {
//		try {
//			File file = new File(reflectionsOutputFile);
//			Scanner scanner = new Scanner(file);
//			while (scanner.hasNextLine()) {
//				String line = scanner.nextLine();
//				if (line.startsWith("Class: ")) {
//					String className = line.substring(7);
//					Class<?> targetClass = Class.forName(className);
//					generateTestCases(targetClass);
//				}
//			}
//			scanner.close();
//		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void generateTestCases(Class<?> targetClass) {
//		StringBuilder testCaseBuilder = new StringBuilder();
//		testCaseBuilder.append("package com.example.UnitTest;\n");
//		
//        generateImports(targetClass, testCaseBuilder);	    
//        testCaseBuilder.append("@SpringBootTest\n");
//		testCaseBuilder.append("public class ").append(targetClass.getSimpleName()).append("TestCase {\n\n");
//
//		testCaseBuilder.append(targetClass.getSimpleName());
//		testCaseBuilder.append(" "+targetClass.getSimpleName().toLowerCase());
//		testCaseBuilder.append(";");
//		testCaseBuilder.append("\n");
//		testCaseBuilder.append("\n");
//		testCaseBuilder.append("@BeforeEach\n");
//		testCaseBuilder.append("public void setUp() { \n");
//		testCaseBuilder.append(targetClass.getSimpleName().toLowerCase()
//				+"= new " + targetClass.getSimpleName()+"();\n");
////		generateFieldAssertions(targetClass, fields, testCaseBuilder);
//		testCaseBuilder.append("}\n");
//		testCaseBuilder.append("\n");
//		
////		Constructor<?>[] constructors = targetClass.getDeclaredConstructors();
//		Field[] fields = targetClass.getDeclaredFields();
//		Method[] methods = targetClass.getDeclaredMethods();
//		
//		
//
//
//		
//		generateFieldAssertions(targetClass, fields, testCaseBuilder);
//
//	
//		for (Method method : methods) {
//	        if (isGetter(method)) {
//	            generateGetterAssertion(targetClass, method, testCaseBuilder);
//	        } else if (isSetter(method)) {
//	            generateSetterAssertion(targetClass, method, testCaseBuilder);
//	        }
//	    }
//		testCaseBuilder.append("}\n");
//		
//
//		String outputFilePath = OUTPUT_DIRECTORY + File.separator + targetClass.getSimpleName() + "TestCase.java";
//		try (PrintWriter writer = new PrintWriter(outputFilePath)) {
//			writer.write(testCaseBuilder.toString());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void generateFieldAssertions(Class<?> targetClass, Field[] fields, StringBuilder testCaseBuilder) {
//		for (Field field : fields) {
//			String fieldName = field.getName();
//			Class<?> fieldType = field.getType();
//			testCaseBuilder.append("@Test\n");
//			testCaseBuilder.append("public void test").append(fieldName).append("() {\n");
//			testCaseBuilder.append(" // Arrange\n");
//			testCaseBuilder.append(" EmployeeModel employee = new EmployeeModel();\n");
//
//			String fieldValue;
//			if (fieldType.equals(String.class)) {
//				fieldValue = "\"John\"";
//			} else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
//				fieldValue = "30";
//			} else if (fieldType.equals(Long.class)) {
//				fieldValue = "1234L";
//			} else {
//
//				fieldValue = "null";
//			}
//			testCaseBuilder.append(" employee.set").append(capitalize(fieldName)).append("(").append(fieldValue)
//					.append(");\n");
//			testCaseBuilder.append(" // Act\n");
//
//			testCaseBuilder.append(" // Assert\n");
//			testCaseBuilder.append(" Assertions.assertEquals(").append(fieldValue).append(", employee.get")
//					.append(capitalize(fieldName)).append("());\n");
//			testCaseBuilder.append("}\n\n");
//		}
//	}
//
//
//	private void generateMethodAssertions(Class<?> targetClass, Method[] methods, StringBuilder testCaseBuilder) {
//		
//	    for (Method method : methods) {
//	        String methodName = method.getName();
//	        Class<?>[] parameterTypes = method.getParameterTypes();
//	        Class<?> returnType = method.getReturnType();
//
//	        if (isGetter(method)) {
//	            // Auto-generate test case for getter method
//	            generateGetterAssertion(targetClass, method, testCaseBuilder);
//	        } else if (isSetter(method)) {
//	            // Auto-generate test case for setter method
//	            generateSetterAssertion(targetClass, method, testCaseBuilder);
//	        } else {
//	            // Handle other methods (if needed)
//	        }
//	    }
//	}

//	private String getFieldNameFromMethodName(String methodName) {
//	    if (methodName.startsWith("get") || methodName.startsWith("set")) {
//	        return methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
//	    } else if (methodName.startsWith("is")) {
//	        return methodName.substring(2, 3).toLowerCase() + methodName.substring(3);
//	    }
//	    return methodName;
//	}
//	
//
//	
//	private void generateGetterAssertion(Class<?> targetClass, Method getterMethod, StringBuilder testCaseBuilder) {
//	    String methodName = getterMethod.getName();
//	    Class<?> returnType = getterMethod.getReturnType();
//
//	    testCaseBuilder.append("@Test\n");
//	    testCaseBuilder.append("public void test").append(capitalize(methodName)).append("() {\n");
//	    testCaseBuilder.append(" // Arrange\n");
//	    testCaseBuilder.append(" ").append(targetClass.getSimpleName()).append(" employee = new ").append(targetClass.getSimpleName()).append("();\n");
//
//	    String defaultValue = getDefaultValue(returnType);
//	    if (defaultValue != null) {
//	        testCaseBuilder.append(" ").append(returnType.getSimpleName()).append(" expectedValue = ").append(defaultValue).append(";\n");
//	    } else {
//	        testCaseBuilder.append(" ").append(returnType.getSimpleName()).append(" expectedValue = null;\n");
//	    }
//
//	    testCaseBuilder.append(" employee.").append(methodName).append("();\n");
//
//	    testCaseBuilder.append(" // Act\n");
//	    testCaseBuilder.append(" ").append(returnType.getSimpleName()).append(" result = employee.").append(methodName).append("();\n");
//
//	    testCaseBuilder.append(" // Assert\n");
//	    testCaseBuilder.append(" Assertions.assertEquals(expectedValue, result, \"").append(methodName).append(" \");\n");
//	    testCaseBuilder.append("}\n\n");
//	}
//
//
//
//	private void generateSetterAssertion(Class<?> targetClass, Method setterMethod, StringBuilder testCaseBuilder) {
//	    String methodName = setterMethod.getName();
//	    Class<?> parameterType = setterMethod.getParameterTypes()[0];
//
//	    testCaseBuilder.append("@Test\n");
//	    testCaseBuilder.append("public void test").append(capitalize(methodName)).append("() {\n");
//	    testCaseBuilder.append(" // Arrange\n");
//	    testCaseBuilder.append(" EmployeeModel employee = new EmployeeModel();\n");
//	    testCaseBuilder.append(" ").append(parameterType.getSimpleName()).append(" expectedValue = ").append(getDefaultValue(parameterType)).append(";\n");
//
//	    if (isGetter(setterMethod)) {
//	        String fieldName = getFieldNameFromMethodName(methodName);
//	        testCaseBuilder.append(" employee.set").append(capitalize(fieldName)).append("(expectedValue);\n");
//	    }
//
//	    testCaseBuilder.append(" // Act\n");
//	    testCaseBuilder.append(" employee.").append(methodName).append("(expectedValue);\n");
//
//	    testCaseBuilder.append(" // Assert\n");
//	    testCaseBuilder.append(" SoftAssertions softAssertions = new SoftAssertions();\n");
//	    testCaseBuilder.append(" softAssertions.assertThat(employee.get").append(capitalize(getFieldNameFromMethodName(methodName))).append("()).isEqualTo(expectedValue);\n");
//	    testCaseBuilder.append(" softAssertions.assertAll();\n");
//	    testCaseBuilder.append("}\n\n");
//	}
//
//
//	
//
//	
//	private boolean isGetter(Method method) {
//	    return method.getName().startsWith("get") &&
//	            method.getParameterCount() == 0 &&
//	            !method.getReturnType().equals(void.class);
//	}
//
//	private boolean isSetter(Method method) {
//	    return method.getName().startsWith("set") &&
//	            method.getParameterCount() == 1 &&
//	            method.getReturnType().equals(void.class);
//	}
//
//	
//
//
//	
//	
//
//
	private void generateImports(Class<?> targetClass, StringBuilder testCaseBuilder) {
		try {
			// Read the import statements from the file
			List<String> importStatements = Files.readAllLines(Paths.get(
					"C:\\Users\\241359\\Documents\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\ImportStatements.txt"));

			// Append the import statements to the testCaseBuilder
			for (String importStatement : importStatements) {
				testCaseBuilder.append(importStatement).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
//
//
//
//
//    String getDefaultValue(Class<?> type) {
//        if (type == boolean.class || type == Boolean.class) {
//            return "false";
//        } else if (type == int.class || type == Integer.class) {
//            return "0"; // Change the default int value to 0
//        } else if (type == long.class || type == Long.class) {
//            return null; // Change the default long value to 0L
//        } else if (type == double.class || type == Double.class) {
//            return "0.0"; // Change the default double value to 0.0
//        } else if (type == float.class || type == Float.class) {
//            return "0.0f"; // Change the default float value to 0.0f
//        } else if (type == char.class || type == Character.class) {
//            return "'\\u0000'"; // Change the default char value to '\u0000'
//        } else if (type == byte.class || type == Byte.class) {
//            return "(byte) 0"; // Change the default byte value to (byte) 0
//        } else if (type == short.class || type == Short.class) {
//            return "(short) 0"; // Change the default short value to (short) 0
//        } else {
//            return "null";
//        }
//    }
//
//	String capitalize(String str) {
//		if (str == null || str.isEmpty()) {
//			return str;
//		}
//		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
//	}
}
