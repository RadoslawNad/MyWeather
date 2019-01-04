package com.myweather.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserCredential {
	
	@NotEmpty(message="Cannot be empty")
	@Email(message="Email incorrect")
	private String email;
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotEmpty(message="Cannot be empty")
	private String password;

}