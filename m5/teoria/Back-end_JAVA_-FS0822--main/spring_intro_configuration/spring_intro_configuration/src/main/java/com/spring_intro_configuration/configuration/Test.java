package com.spring_intro_configuration.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Test {
	
	private String name;
	
	public String saluta() {
		return "ciao " + name;
	}
	

}
