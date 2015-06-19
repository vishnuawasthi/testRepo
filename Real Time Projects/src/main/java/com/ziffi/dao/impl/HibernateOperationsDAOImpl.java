/**
 * 
 */
package com.ziffi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;	
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ziffi.dao.HibernateOperationsDAO;
import com.ziffi.entity.Media;
import com.ziffi.entity.Profile;

/**
 * @author vawasthi
 *
 */
@Component("HibernateOperationsDAO")
@Repository("HibernateOperationsDAO")
public class HibernateOperationsDAOImpl<T> implements HibernateOperationsDAO<T> {

	@Autowired(required=true)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public boolean validateUser(T objectTosave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(T objectToSave) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(objectToSave);
		tx.commit();
	}

	@Override
	public void delete(T objectToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T objectToUpdate) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return sessionFactory.openSession().createCriteria(Media.class).list();
	}
	
	

}
