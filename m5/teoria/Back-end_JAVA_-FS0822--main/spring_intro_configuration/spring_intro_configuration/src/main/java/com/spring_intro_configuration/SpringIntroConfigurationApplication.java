package com.spring_intro_configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_intro_configuration.configuration.ConfigurationTest;
import com.spring_intro_configuration.configuration.Test;
import com.spring_intro_configuration.configuration_Component.TestComponent;
import com.spring_intro_configuration.configuration_XML.TestXml;

@SpringBootApplication
public class SpringIntroConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroConfigurationApplication.class, args);
	
		// Configurazione 1
		// Configurazione dei bean tramite una classe Configuration
		configWith_Beans1();
		
		// Configurazione 2
		// Configurazione dei bean tramite file XML
		//configWith_XML1();
		
		// Configurazione 3
		// Configurazione dei bean tramite annotation @Component("name")
		//configWith_Components1();
	
	}
	
	public static void configWith_Beans1() {
		AnnotationConfigApplicationContext appContext = 
				new AnnotationConfigApplicationContext(ConfigurationTest.class);
	
		//Recupero Bean
		Test t1 = (Test) appContext.getBean("test");
		//Test t1c = (Test) appContext.getBean("test");
		System.out.println(t1);

		//System.out.println(t1.saluta());
		
		//Recupero Bean con paramentri
		Test t2 = (Test) appContext.getBean("paramtest", "Param Test");
		System.out.println(t2);
		//System.out.println(t2.saluta());
		
		//Test t3 = (Test) appContext.getBean("abc");
		
		appContext.close();
		
		
	}

	public static void configWith_XML1() {
		ClassPathXmlApplicationContext appContext = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		//Recupero Bean
		TestXml t1 = (TestXml) appContext.getBean("TestXml");
		System.out.println(t1.saluta());
		
		appContext.close();
	}
	
	public static void configWith_Components1() {
		AnnotationConfigApplicationContext appContext = 
				new AnnotationConfigApplicationContext();
		
		appContext.scan("com.spring_intro_configuration.configuration_Component");
		appContext.refresh();
		
		//Recupero Bean
		TestComponent t1 = (TestComponent) appContext.getBean("TestComponent");
		t1.setName("Test Component");
		System.out.println(t1.saluta());
		
		//Recupero Bean con parametri
		TestComponent t2 = (TestComponent) appContext.getBean("TestComponent", "Test Component Params");
		System.out.println(t2.saluta());
		
		appContext.close();
	}
	
	
}
