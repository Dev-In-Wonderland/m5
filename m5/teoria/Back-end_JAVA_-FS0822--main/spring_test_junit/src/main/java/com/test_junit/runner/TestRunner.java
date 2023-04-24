package com.test_junit.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.test_junit.configuration.UserConfiguration;
import com.test_junit.model.User;

@Component
public class TestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test run...");
		//configWith_Beans();
		
	}
	
	public static void configWith_Beans() {
		AnnotationConfigApplicationContext appContext = 
				new AnnotationConfigApplicationContext(UserConfiguration.class);
	
		User u1 = (User) appContext.getBean("customUser");
		u1.setName("Giuseppe");
		u1.setLastname("Verdi");
		u1.setEmail("g.verdi@example.com");
		u1.setPassword("12345");
		System.out.println(u1);
		
		User u2 = (User) appContext.getBean("newUser", "Francesca", "Neri", "f.neri@example.com", "pass");
		System.out.println(u2);
		
		User u3 = (User) appContext.getBean("adminUser");
		System.out.println(u3);
		
		appContext.close();	
	}

}
