package com.myweather.repository;

import com.myweather.model.User;

public interface UserRepository{
		
	public User findByUsername(String username);
	
	public void save(User registerUser);
	
}
