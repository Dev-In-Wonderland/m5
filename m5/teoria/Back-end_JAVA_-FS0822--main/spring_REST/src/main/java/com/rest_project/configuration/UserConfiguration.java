package com.rest_project.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.rest_project.model.User;

@Configuration
public class UserConfiguration {
	
	@Value("${user.admin.name}") private String adminName;
	@Value("${user.admin.lastname}") private String adminLastname;
	@Value("${user.admin.email}") private String adminEmail;
	@Value("${user.admin.age}") private Integer adminAge;
	@Value("${user.admin.city}") private String adminCity;
	@Value("${user.admin.password}") private String adminPassword;
	
	@Bean("AdminUserBean")
	@Scope("singleton")
	public User newAdminUser() {
		return User.builder()
				.name(adminName)
				.lastname(adminLastname)
				.email(adminEmail)
				.age(adminAge)
				.city(adminCity)
				.password(adminPassword)
				.build();
	}
	
	@Bean("FakeUserBean")
	@Scope("prototype")
	public User newFakeUser() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		return User.builder()
				.name(fake.name().firstName())
				.lastname(fake.name().lastName())
				.email(fake.internet().emailAddress())
				.age(fake.number().numberBetween(16, 80))
				.city(fake.address().cityName())
				.password(fake.internet().password(6, 10, true, true))
				.build();
	}
	
	@Bean("CustomUserBean")
	@Scope("prototype")
	public User newCustomUser() {
		return new User();
	}

}
