package com.myweather.domain.repository.historyDao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myweather.domain.WeatherObject;

@Repository
public class HistoryDaoImpl implements HistoryDao {

	private static final Logger logger = LogManager.getLogger(HistoryDaoImpl.class);

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
