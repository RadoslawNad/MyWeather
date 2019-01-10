package com.myweather.repository;

import java.util.List;
import com.myweather.model.WeatherObject;

public interface WeatherApi {
	
	public void populateList();

	public List<WeatherObject> getAllLocations();
	
	public List<String> getLocationsName();
	
	public WeatherObject getLocationByName(String name);
}
