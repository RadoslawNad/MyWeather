package com.myweather.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweather.model.WeatherObject;
import com.myweather.repository.HistoryDao;
import com.myweather.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	private HistoryDao historyDao;

	@Override
	@Transactional
	public void saveHistory(WeatherObject weatherObject) {
		historyDao.saveHistory(weatherObject);
	}

	@Override
	@Transactional
	public List<WeatherObject> getHistory() {	
		return historyDao.getHistory();
	}

}
