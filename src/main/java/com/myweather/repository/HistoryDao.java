package com.myweather.repository;

import java.util.List;

import com.myweather.model.User;
import com.myweather.model.WeatherObject;

public interface HistoryDao {
		
	public void saveHistory(String currentlyUsername, WeatherObject weatherData);
	
	public List<User> getAllHistory();
	
	public List<User> getUserHistory(String currentlyUsername);
	
}
