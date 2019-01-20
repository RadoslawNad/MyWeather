package com.myweather.repository;

import com.myweather.model.User;

public interface UserRepository{
		
	public User findUser(String username);
	
	public void saveUser(User user);
	
}
