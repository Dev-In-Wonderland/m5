package com.mvc_project.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
	
	@NotNull
	private String fullname;
	@NotNull
	private String email;
	@NotNull
	@Size(min = 6, max = 10)
	private String password;

}
