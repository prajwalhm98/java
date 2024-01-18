package com.example.UnitTest;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestingApplication {

    public static void main(String[] args) {
    	 TestGeneration testGeneration = new TestGeneration();
         testGeneration.generateTestCases("com.example.UnitTest");
        
        
     }
    }

    
    
