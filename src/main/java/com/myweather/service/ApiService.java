package com.myweather.service;

import java.util.List;

import com.myweather.model.WeatherObject;

public interface ApiService {
	
	public List<String> getLocationsName();
	
	public WeatherObject getLocationByName(String name);
}
