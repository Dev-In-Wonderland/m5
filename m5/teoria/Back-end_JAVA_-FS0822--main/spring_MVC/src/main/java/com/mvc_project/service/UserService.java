package com.mvc_project.service;

import org.springframework.stereotype.Service;

import com.mvc_project.model.User;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	public User createUser() { 
		User u = User.builder()
				.fullname("Mario Rossi")
				.email("m.rossi@example.com")
				.password("qwerty")
				.build();
	/*
	 * User u2 = new User(); u2.setFullname("Mario Rossi");
	 * u2.setEmail("m.rossi@example.com"); u2.setPassword("qwerty");
	 */
		return u;
	}
	
	public User getUserbyEmail(String email) {
		throw new EntityNotFoundException("User not exists!!!");
	}

}
