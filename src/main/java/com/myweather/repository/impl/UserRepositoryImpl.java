package com.myweather.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.NonUniqueResultException;
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
	public void save(User registerUser) {
		logger.info("New user added with username" + registerUser.getUsername());
		currentSession().save(registerUser);
	}

	@Override
	public User findByUsername(String username) {
		logger.info("Find user with email" + username);

		CriteriaBuilder builder = currentSession().getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("username"), username));
		Query<User> q = currentSession().createQuery(query);
		try {
			return q.getSingleResult();
		} catch (final NoResultException nre) {
			return null;
		} catch (final NonUniqueResultException nre) {
			return null;
		}
	}

}
