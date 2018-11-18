package com.myweather.service;

import java.util.List;

import com.myweather.domain.WeatherObject;

public interface HistoryService {
	public void saveHistory(WeatherObject weatherObject);
	public List<WeatherObject> getHistory();
}
