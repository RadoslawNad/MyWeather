package com.myweather.repository;

import com.myweather.model.User;

public interface UserRepository{
		
	public User findByEmail(String email);
	
	public void save(User registerUser);
	
}
