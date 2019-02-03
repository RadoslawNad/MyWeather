package com.myweather.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.myweather.model.WeatherObject;
import com.myweather.util.impl.WeatherDataConverterImpl;

class WeatherDataConverterTest {
	
	static WeatherDataConverter dataConverter;
	static WeatherObject object;
	
    @BeforeAll
    static void initAll() {
    	dataConverter=new WeatherDataConverterImpl();
    	object=new WeatherObject();
    }

	@Test
	void doesReturnN() {
		object.setWindDirection("337.5");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(N) 337.5");
		
		object.setWindDirection("22");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(N) 22");
	}
	
	@Test
	void doesReturnNE() {
		object.setWindDirection("22.5");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(NE) 22.5");
		
		object.setWindDirection("67");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(NE) 67");
	}
	
	@Test
	void doesReturnE() {
		object.setWindDirection("67.5");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(E) 67.5");
		
		object.setWindDirection("112");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(E) 112");
	}
	
	@Test
	void doesReturnSE() {
		object.setWindDirection("112.5");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(SE) 112.5");
		
		object.setWindDirection("157");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(SE) 157");
	}
	
	@Test
	void doesReturnS() {
		object.setWindDirection("157.5");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(S) 157.5");
		
		object.setWindDirection("202");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(S) 202");
	}
	
	@Test
	void doesReturnSW() {
		object.setWindDirection("202.5");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(SW) 202.5");
		
		object.setWindDirection("247");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(SW) 247");
	}
	
	@Test
	void doesReturnW() {
		object.setWindDirection("247.5");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(W) 247.5");
		
		object.setWindDirection("292");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(W) 292");
	}
	
	@Test
	void doesReturnNW() {
		object.setWindDirection("292.5");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(NW) 292.5");
		
		object.setWindDirection("337");
		assertEquals(dataConverter.converter(object).getWindDirection(),"(NW) 337");
	}
	
}
