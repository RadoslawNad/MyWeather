package com.myweather.service.impl;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweather.domain.WeatherObject;
import com.myweather.domain.repository.weatherApi.WeatherApi;
import com.myweather.service.DisplayObjectService;

@Service
public class DisplayObjectServiceImpl implements DisplayObjectService {
	
	@Autowired
	private WeatherApi weatherApi;
	
	private WeatherObject displayObject=null;
	

	public void setObject(WeatherObject weatherObject) {
		String cityName =weatherObject.getStationName();
		try {
			cityName = new String(cityName.getBytes("ISO8859_1"), "UTF8");
			displayObject=weatherApi.getLocationByName(cityName);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}

		
		
	}

	public WeatherObject getObject() {
		return displayObject;
	}

}
