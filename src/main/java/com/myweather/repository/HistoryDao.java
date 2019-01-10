package com.myweather.repository;

import java.util.List;
import com.myweather.model.WeatherObject;

public interface HistoryDao {
	
	public void saveHistory(WeatherObject weatherObject);
	public List<WeatherObject> getHistory();

}
