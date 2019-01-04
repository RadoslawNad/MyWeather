package com.myweather.domain.repository.historyDao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.myweather.domain.WeatherObject;
import com.myweather.exception.SessionFactoryError;
import com.myweather.util.HibernateUtil;

@Repository
public class HistoryDaoImpl implements HistoryDao {
	
	private static final Logger logger = LogManager
			.getLogger(HistoryDaoImpl.class);

	public void saveHistory(WeatherObject weatherObject) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(weatherObject);
			session.getTransaction().commit();
			logger.info("History saved successful with data name: "
					+ weatherObject.getStationName());
		} catch (HibernateException e) {
			logger.error("saveHistory().Exception while getting session. Message:  "
					+ e);
		} catch (Exception e) {
			logger.error("saveHistory().No connection to the database.  "
					+ e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<WeatherObject> getHistory() {
		Session session = null;
		List<WeatherObject> weatherObject = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<WeatherObject> query = builder
					.createQuery(WeatherObject.class);
			Root<WeatherObject> root = query.from(WeatherObject.class);
			query.select(root);
			Query<WeatherObject> q = session.createQuery(query);
			weatherObject = q.getResultList();
			session.getTransaction().commit();
			logger.info("History data downloaded successful.");

		} catch (HibernateException e) {
			logger.error("getHistory().Exception while getting session. Message "
					+ e);
		} catch (Exception e) {
			logger.error("getHistory().No connection to the database.  "
					+ e);
			throw new SessionFactoryError();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return weatherObject;
	}

}
