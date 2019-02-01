package com.myweather.rest.client;

import java.util.List;

import com.myweather.model.CityDTO;
import com.myweather.model.WeatherObject;

public interface WeatherClient {
	
	public List<CityDTO> getNamesOfCities();
	
	public WeatherObject getWeatherByCity(String id);

}
