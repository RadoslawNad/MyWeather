package com.myweather.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweather.model.Role;
import com.myweather.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Role findByRole(String name) {
		CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        query.select(root).where(builder.equal(root.get("name"),name));
        Query<Role> q=currentSession().createQuery(query);
        try {
            return q.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
	}

	@Override
	public void save(Role role) {
		currentSession().save(role);
	}

}
