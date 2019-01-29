package com.myweather.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweather.model.WeatherObject;
import com.myweather.repository.WeatherApi;
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
		return weatherApi.getLocationByName(stringEncoding(name));
	}

	public String stringEncoding(String string) {
		try {
			string = new String(string.getBytes("ISO8859_1"), "UTF8");
		} catch (UnsupportedEncodingException e) {
		}
		return string;
	}

}
