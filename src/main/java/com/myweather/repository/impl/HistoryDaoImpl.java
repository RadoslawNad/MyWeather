package com.myweather.repository.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweather.model.WeatherObject;
import com.myweather.repository.HistoryDao;

@Repository
public class HistoryDaoImpl implements HistoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveHistory(WeatherObject weatherObject) {
		currentSession().save(weatherObject);
	}

	@Override
	public List<WeatherObject> getHistory() {
		CriteriaBuilder builder = currentSession().getCriteriaBuilder();
		CriteriaQuery<WeatherObject> criteria = builder.createQuery(WeatherObject.class);
		criteria.from(WeatherObject.class);
		List<WeatherObject> history = currentSession().createQuery(criteria).getResultList();
		return history;
	}
}
