package com.myweather.domain.repository.weatherApi;

import java.util.List;

import com.myweather.domain.WeatherObject;

public interface WeatherApi {
	
	public void populateList();

	public List<WeatherObject> getAllLocations();
	
	public List<String> getLocationsName();
	
	public WeatherObject getLocationByName(String name);
}
