package com.mvc_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mvc_project.model.User;
import com.mvc_project.service.UserService;

import jakarta.validation.Valid;

@Controller
public class FormController {
	
	@Autowired UserService userService;
	
	@GetMapping("/register")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView showFormRegister() {
		return new ModelAndView("register", "userRegister", new User());
	}
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public String submit(
			@Valid
			@ModelAttribute("userRegister") User userRegister,
			BindingResult result,
			ModelMap model) {
		if(result.hasErrors()) {
			//System.out.println("ERRORE!!!!");
			return "errorPage";
		} 	
		model.addAttribute("user", userRegister);
		return "homepage";
	}
	
	@GetMapping("/test")
	//@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
	public ResponseEntity<String> test() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("name", "Emanuele Umberto");
		String body = "Ciao a tutti";
		ResponseEntity<String> resp = new ResponseEntity<String>(body, headers, HttpStatus.OK);
		return resp;
	}
	
	//@GetMapping(value="/users", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/users")
	public ResponseEntity<User> users() {
		ResponseEntity<User> resp = new ResponseEntity<User>(userService.createUser(),HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/users/error")
	public ResponseEntity<?> usersError() {
		ResponseEntity<User> resp = new ResponseEntity<User>(userService.getUserbyEmail("abc"),HttpStatus.OK);
		return resp;
	}

}
