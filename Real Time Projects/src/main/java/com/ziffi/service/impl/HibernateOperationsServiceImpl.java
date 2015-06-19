/**
 * 
 */
package com.ziffi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziffi.dao.HibernateOperationsDAO;

/**
 * @author vawasthi
 *
 */
@Service("HibernateOperationsService")
public class HibernateOperationsServiceImpl<T> implements HibernateOperationsService<T> {

	@Autowired
	private HibernateOperationsDAO<T> hibernateOperationsDAO;
	
	@Override
	public boolean validateUser(T objectTosave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(T objectToSave) {
		hibernateOperationsDAO.save(objectToSave);		
	}

	@Override
	public void delete(T objectToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T objectToUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> list() {
		return hibernateOperationsDAO.list();
	}
	

}
