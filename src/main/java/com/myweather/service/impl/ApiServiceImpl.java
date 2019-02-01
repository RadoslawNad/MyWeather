package com.myweather.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweather.model.CityDTO;
import com.myweather.model.WeatherObject;
import com.myweather.rest.client.WeatherClient;
import com.myweather.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

	@Autowired
	private WeatherClient weatherClient;

	private List<CityDTO> city = null;

	public List<String> getLocationsName() {
		city = weatherClient.getNamesOfCities();
		return getCitiesList();
	}

	public WeatherObject getLocationByName(String name) {
		String stationId = getStationId(name);
		return weatherClient.getWeatherByCity(stationId);
	}

	//retrieve list of cityNames from city object
	private List<String> getCitiesList() {
		List<String> cities = new ArrayList<String>();
		for (CityDTO city : city) {
			cities.add(city.getStationName());
		}
		return cities;
	}

	// retrieve stationId by cityName in local List<CityDTO>city;
	private String getStationId(String name) {
		String stationId = null;
		for (CityDTO city : city) {
			if (city.getStationName().equals(stringEncoding(name))) {
				stationId = city.getStationId();
			}
		}
		return stationId;
	}

	// encoding String from ISO8859_1 to UTF-8
	private String stringEncoding(String string) {
		try {
			string = new String(string.getBytes("ISO8859_1"), "UTF8");
		} catch (UnsupportedEncodingException e) {
		}
		return string;
	}

}
