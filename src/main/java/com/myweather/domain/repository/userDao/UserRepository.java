package com.myweather.domain.repository.userDao;

import com.myweather.domain.User;

public interface UserRepository{
		
	public User findByEmail(String email);
	
	public void save(User registerUser);
	
}
