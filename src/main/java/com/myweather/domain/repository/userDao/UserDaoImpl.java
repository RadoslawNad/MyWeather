package com.myweather.domain.repository.userDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.myweather.domain.User;
import com.myweather.exception.SessionFactoryError;
import com.myweather.util.HibernateUtil;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

	@Override
	public void saveUser(User user) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(user);
			session.getTransaction().commit();
			logger.info("User saved successful with data name: " + user.getName());
		} catch (HibernateException e) {
			logger.error("saveUser().Exception while getting session. Message:  " + e);
		} catch (Exception e) {
			logger.error("saveUser().No connection to the database.  " + e);
			throw new SessionFactoryError();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public User findEmail(String email) {
		String hql = "SELECT u FROM User u WHERE u.email = :email";
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			user = (User) session.createQuery(hql)
					.setParameter("email", email)
					.uniqueResult();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			logger.error("findEmail().Exception while getting session. Message:  " + e);
		} catch (NullPointerException e) {
			logger.info("findEmail(). Email not founded  " + e);
			return null;
		} catch (Exception e) {
			logger.error("findEmail().No connection to the database.  " + e);
			throw new SessionFactoryError();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;
	}

	@Override
	public User getUserDetailsByEmailAndPassword(String email, String password) {
		String hql = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			user = (User) session.createQuery(hql)
					.setParameter("email", email)
					.setParameter("password", password)
					.uniqueResult();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			logger.error("getStudentDetailsByEmailAndPassword().Exception while getting session. Message:  " + e);
		} catch (NullPointerException e) {
			logger.info("getStudentDetailsByEmailAndPassword(). Email not founded  " + e);
			return null;
		} catch (Exception e) {
			logger.error("getStudentDetailsByEmailAndPassword().No connection to the database.  " + e);
			throw new SessionFactoryError();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;
	}
}
