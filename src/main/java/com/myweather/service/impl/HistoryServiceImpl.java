package com.myweather.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweather.domain.WeatherObject;
import com.myweather.domain.repository.historyDao.HistoryDao;
import com.myweather.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	private HistoryDao historyDao;

	@Override
	public void saveHistory(WeatherObject weatherObject) {
		historyDao.saveHistory(weatherObject);
	}

	@Override
	public List<WeatherObject> getHistory() {	
		return historyDao.getHistory();
	}

}
