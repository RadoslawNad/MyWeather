package com.myweather.service;

import com.myweather.domain.User;

public interface UserService {
	
	public boolean saveUser(User user);

	public User validateUserCredential(String email, String password); 
}
