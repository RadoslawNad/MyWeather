package com.myweather.util.impl;

import org.springframework.stereotype.Component;

import com.myweather.model.WeatherObject;
import com.myweather.util.WeatherDataConverter;

@Component
public class WeatherDataConverterImpl implements WeatherDataConverter {

	private static final float NNE = 22.5F;
	private static final float ENE = 67.5F;
	private static final float ESE = 112.5F;
	private static final float SSE = 157.5F;
	private static final float SSW = 202.5F;
	private static final float WSW = 247.5F;
	private static final float WNW = 292.5F;
	private static final float NNW = 337.5F;
	
	@Override
	public WeatherObject converter(WeatherObject weatherObject) {
		String degree=weatherObject.getWindDirection();
		weatherObject.setWindDirection(convertWindDirection(degree)+ " " +degree);
	
		return weatherObject;
	}
	
	
	/**
	 * converting wind direction from direction degrees to direction names
	 * 
	 * @param degree for example (150)
	 * @return converted direction in for example(SE)
	 */
	private String convertWindDirection(String degree) {
		float d = Float.parseFloat(degree);

		if (d > NNW && d < NNE) {
			return "(N) ";

		} else if (d > NNE && d < ENE) {
			return "(NE) ";

		} else if (d > ENE && d < ESE) {
			return "(E) ";

		} else if (d > ESE && d < SSE) {
			return "(SE) ";

		} else if (d > SSE && d < SSW) {
			return "(S) ";

		} else if (d > SSW && d < WSW) {
			return "(SW) ";

		} else if (d > WSW && d < WNW) {
			return "(W) ";
		}else {
			return "(NW) ";
		}
		
	}

}
