package com.myweather.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.myweather.model.User;
import com.myweather.model.WeatherObject;

public interface UserService extends UserDetailsService {

	public User findByUsername(String username);

	public void saveUser(User user);

	public void saveHistory(String currentlyUsername, WeatherObject weatherData);

	public List<User> getAllHistory();

	public List<User> getUserHistory(String currentlyUsername);

}
