package com.myweather.rest.client.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.myweather.model.CityDTO;
import com.myweather.model.WeatherObject;
import com.myweather.rest.client.WeatherClient;

@Repository
public class WeatherClientImpl implements WeatherClient {
	
	public static final String JSON_URL = "https://danepubliczne.imgw.pl/api/data/synop";
	
	@Override
	public List<CityDTO> getNamesOfCities() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<CityDTO>> response = restTemplate.exchange(JSON_URL,HttpMethod.GET,
				null, new ParameterizedTypeReference<List<CityDTO>>(){});
		List<CityDTO> cities = response.getBody();
		return cities;
	}
	
	@Override
	public WeatherObject getWeatherByCity(String id) {
		RestTemplate restTemplate = new RestTemplate();
		WeatherObject weatherObject=restTemplate.getForObject(JSON_URL+"/id/"+id, WeatherObject.class);
		return weatherObject;
	}

}
