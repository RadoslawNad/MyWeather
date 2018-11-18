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
import com.myweather.util.HibernateUtil;

@Repository
public class HistoryDaoImpl implements HistoryDao {
	private static Logger logger = LogManager.getRootLogger();


	public void saveHistory(WeatherObject weatherObject) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.persist(weatherObject);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.error("HistoryDaoImpl/saveHistory().Exception while getting session: "+e);
		}
	}

	public List<WeatherObject> getHistory() {
		Session session=null;
		List<WeatherObject> weatherObject = null;
		try  {
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
			
		} catch (HibernateException e) {
			logger.error("HistoryDaoImpl/getHistory().Exception while getting session: "+e);

		}finally{
			session.close();
		}
		return weatherObject;
	}

}
