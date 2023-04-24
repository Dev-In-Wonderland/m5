package com.jpac_project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jpac_project.model.User;
import com.jpac_project.service.UserService;

@Component
public class UserRunner implements ApplicationRunner {
	
	@Autowired UserService userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		//userService.createFakeUser();
		//userService.findAllUser().forEach(u -> System.out.println(u));
		//User u = userService.findUserByID(3l);
		//System.out.println(u);
		//u.setCity("Milano");
		//userService.updateUser(u);
		//userService.removeUser(u);
		userService.findAgeOver(50).forEach(e -> System.out.println(e));
		//userService.findCityIn().forEach(e -> System.out.println(e));
	}

}
