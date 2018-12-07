package com.myweather.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;


import com.myweather.service.impl.ApiServiceImpl;

@RunWith(JUnitPlatform.class)
class ApiServiceTest {

	static ApiServiceImpl apiServiceImpl;

	@BeforeAll
	  static void setUp() {
		apiServiceImpl = new ApiServiceImpl();
	}

	@Test
	 void do_encode_string() {

		String city = "Łódź";

		String result = apiServiceImpl.StringEncoding(city);

		assertEquals(city, result);
	}
}
