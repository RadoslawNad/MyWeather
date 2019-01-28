package com.myweather.repository.impl;

import javax.persistence.NoResultException;

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


	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveUser(User user) {
		currentSession().save(user);
	}

	@Override
	public User findUser(String username) {
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
