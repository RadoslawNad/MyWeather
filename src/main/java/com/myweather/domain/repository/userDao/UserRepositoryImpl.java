package com.myweather.domain.repository.userDao;

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

import com.myweather.domain.User;

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
		logger.info("New user added with username" + registerUser.getEmail());
		currentSession().save(registerUser);
	}

	@Override
	public User findByEmail(String email){
		logger.info("Find user with email" + email);

		CriteriaBuilder builder = currentSession().getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("email"), email));
		Query<User> q = currentSession().createQuery(query);
		try {
			return q.getSingleResult();
		} catch (final NoResultException nre) {
			return null;
		}
		catch (final NonUniqueResultException nre) {
			return null;
		}
	}

//	@Override
//	public User getUserDetailsByEmailAndPassword(String email, String password) {
//		String hql = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
//		Session session = null;
//		User user = null;
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//
//			user = (User) session.createQuery(hql).setParameter("email", email).setParameter("password", password)
//					.uniqueResult();
//
//			session.getTransaction().commit();
//		} catch (HibernateException e) {
//			logger.error("getStudentDetailsByEmailAndPassword().Exception while getting session. Message:  " + e);
//		} catch (NullPointerException e) {
//			logger.info("getStudentDetailsByEmailAndPassword(). Email not founded  " + e);
//			return null;
//		} catch (Exception e) {
//			logger.error("getStudentDetailsByEmailAndPassword().No connection to the database.  " + e);
//			throw new SessionFactoryError();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return user;
//	}
}
