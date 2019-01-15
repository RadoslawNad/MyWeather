package com.myweather.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.myweather.model.User;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(User user);

}
