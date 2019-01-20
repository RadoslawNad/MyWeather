package com.myweather.repository.impl;

import javax.persistence.NoResultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweather.model.User;
import com.myweather.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = LogManager.getLogger(UserRepositoryImpl.class);

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveUser(User user) {
		logger.info("New user added with username" + user.getUsername());
		currentSession().save(user);
	}

	@Override
	public User findUser(String username) {
		logger.info("Find user with email" + username);
		User user = null;
		try {
			Query<User> query = currentSession().createQuery("SELECT u FROM User u WHERE u.username=:theUsername",
					User.class);
			query.setParameter("theUsername", username);
			user = query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return user;
	}

}
