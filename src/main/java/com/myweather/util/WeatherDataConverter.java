package com.myweather.util;

import com.myweather.model.WeatherObject;

public interface WeatherDataConverter {
	
	public WeatherObject converter(WeatherObject weatherObject);
}
