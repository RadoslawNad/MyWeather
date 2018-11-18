package com.myweather.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myweather.domain.WeatherObject;
import com.myweather.domain.repository.weatherApi.WeatherApi;
import com.myweather.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {
	
	@Autowired
	private WeatherApi weatherApi;

	public void populateList() {
		weatherApi.populateList();	
	}

	public List<WeatherObject> getAllLocations() {
		return weatherApi.getAllLocations();
	}

	public List<String> getLocationsName() {
		return weatherApi.getLocationsName();
	}

	public WeatherObject getLocationByName(String name) {
		return weatherApi.getLocationByName(name);
	}

}
