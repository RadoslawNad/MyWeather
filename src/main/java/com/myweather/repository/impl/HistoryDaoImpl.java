package com.myweather.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweather.model.User;
import com.myweather.model.WeatherObject;
import com.myweather.repository.HistoryDao;
import com.myweather.repository.UserRepository;

@Repository
public class HistoryDaoImpl implements HistoryDao {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveHistory(String currentlyUsername,WeatherObject watherData) {
		User user=userRepository.findUser(currentlyUsername);
		user.setHistory(Arrays.asList(watherData));	
		currentSession().save(user);
	}
	

	@Override
	public List<User> getAllHistory() {	
		Query<User>query=currentSession().createQuery("SELECT u FROM User u ORDER BY u.username ASC",User.class);
		List<User>allHistoryList=query.getResultList();
		return allHistoryList;
	}

	@Override
	public List<User> getUserHistory(String currentlyUsername) {	
		Query<User>query=currentSession().createQuery("SELECT u FROM User u WHERE u.username=:theUsername",User.class);
		query.setParameter("theUsername", currentlyUsername);
		List<User> historyList=query.getResultList();
		return historyList;
	}
	
	
}
