package com.myweather.repository.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myweather.model.WeatherObject;
import com.myweather.repository.WeatherApi;

@Repository
public class WeatherApiImpl implements WeatherApi {


	public static final String JSON_URL = "https://danepubliczne.imgw.pl/api/data/synop";
	private List<WeatherObject> weatherList;

	public void populateList() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<WeatherObject>> rateResponse = restTemplate
				.exchange(JSON_URL, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<WeatherObject>>() {
						});
		List<WeatherObject> weather = rateResponse.getBody();
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(weather);
			weatherList = mapper.readValue(jsonArray,
					new TypeReference<List<WeatherObject>>() {
					});

		} catch (JsonProcessingException e) {
		} catch (IOException e) {
		}
	}

	public List<WeatherObject> getAllLocations() {
		return weatherList;
	}

	public List<String> getLocationsName() {
		List<String> namesList = new ArrayList<String>();
		for (WeatherObject weatherObject : weatherList) {
			namesList.add(weatherObject.getStationName());
		}
		return namesList;
	}

	public WeatherObject getLocationByName(String name) {
		WeatherObject locatiobByName = null;
		for (WeatherObject location : weatherList) {
			if (location != null && location.getStationName() != null
					&& location.getStationName().equalsIgnoreCase(name)) {
				locatiobByName = location;
				break;
			}
		}
		if (locatiobByName == null) {
			throw new IllegalArgumentException("Data was not found for: "
					+ name);
		}
		return locatiobByName;
	}

	public List<WeatherObject> getWeatherList() {
		return weatherList;
	}

	public void setWeatherList(List<WeatherObject> weatherList) {
		this.weatherList = weatherList;
	}
}
