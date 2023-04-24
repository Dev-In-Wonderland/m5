package com.test_junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test_junit.model.User;

public class UserTest {
	
	User u;
	
	@BeforeAll
	public static void beforeClassTest() {
		System.out.println("beforClassTest");
	}
	
	@BeforeEach
	public void beforeTest() {
		u = new User("Mario", "Rossi", "m.rossi@example.com", "qwerty");
		System.out.println("beforeTest");
	}
	
	@Test
	public void testPassword() {
		//User u = new User("Mario", "Rossi", "m.rossi@example.com", "qwerty");
		//assertEquals("qwerty", u.getPassword());
		assertTrue(u.getPassword().length() > 5);
		System.out.println("testPassword");
	}
	
	@Test
	//@Disabled
	public void testEmail() {
		//User u = new User("Mario", "Rossi", "m.rossi@example.com", "qwerty");
		assertEquals("m.rossi@example.com", u.getEmail());
		System.out.println("testEmail");
	}
	
	@AfterEach
	public void afterTest() {
		u = null;
		System.out.println("afterTest");
	}
	
	@AfterAll
	public static void afterClassTest() {
		System.out.println("afterClassTest");
	}

}
