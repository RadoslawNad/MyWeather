package com.myweather.service;

import java.util.List;
import com.myweather.model.WeatherObject;


public interface ApiService {
	public void populateList();

	public List<WeatherObject> getAllLocations();
	
	public List<String> getLocationsName();
	
	public WeatherObject getLocationByName(String name);
}
