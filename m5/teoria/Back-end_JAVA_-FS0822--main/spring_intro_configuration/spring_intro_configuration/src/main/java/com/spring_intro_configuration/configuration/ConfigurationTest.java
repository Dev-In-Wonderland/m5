package com.spring_intro_configuration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationTest {
	
	@Bean
	@Scope("singleton")
	public Test test() {
		return new Test("Mario Test!!!");
	}
	
	@Bean
	@Scope("prototype")
	public Test paramtest(String name) {
		return new Test(name);
	}

	@Bean
	public Test abc() {
		return new Test("Mario Test!!!");
	}

}
