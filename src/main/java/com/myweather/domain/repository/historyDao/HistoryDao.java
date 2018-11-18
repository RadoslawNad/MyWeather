package com.myweather.domain.repository.historyDao;

import java.util.List;
import com.myweather.domain.WeatherObject;

public interface HistoryDao {
	
	public void saveHistory(WeatherObject weatherObject);
	public List<WeatherObject> getHistory();

}
