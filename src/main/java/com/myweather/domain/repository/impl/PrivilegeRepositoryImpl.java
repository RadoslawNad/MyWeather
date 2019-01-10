package com.myweather.domain.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myweather.domain.Privilege;
import com.myweather.domain.repository.PrivilegeRepository;

@Repository
public class PrivilegeRepositoryImpl implements PrivilegeRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Privilege findByName(String name) {
		CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Privilege> query = builder.createQuery(Privilege.class);
        Root<Privilege> root = query.from(Privilege.class);
        query.select(root).where(builder.equal(root.get("name"),name));
        Query<Privilege> q=currentSession().createQuery(query);
        try {
            return q.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
	}

	@Override
	public void save(Privilege privilege) {
		currentSession().save(privilege);
	}
}
