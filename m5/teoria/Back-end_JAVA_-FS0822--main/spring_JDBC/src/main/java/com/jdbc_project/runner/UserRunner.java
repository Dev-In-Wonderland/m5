package com.jdbc_project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.jdbc_project.configuration.UserConfiguration;
import com.jdbc_project.model.User;
import com.jdbc_project.repository.UserJDBCDao;
import com.jdbc_project.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class UserRunner implements CommandLineRunner{
	
	@Autowired  UserService userservice;

	@Override
	public void run(String... args) throws Exception {
		log.info("Run.. UserRunner");
		//userservice.createFakeUser();
		//userservice.createAdminUser();
		//User u = userservice.findUserByID(2l);
		//u.setPassword("$$$$$$$$$");
		//userservice.updateUser(u);
		//log.info(u.toString());
		//userservice.removeUser(2l);
		//userservice.findAllUser().forEach(u -> System.out.println(u));
	}

}
