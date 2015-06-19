/**
 * 
 */
package com.ziffi.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ziffi.dao.SchedulerDAO;
import com.ziffi.entity.Task;

/**
 * @author vawasthi
 *
 */
@Component("SchedulerDAO")
//@Repository("HibernateOperationsDAO")
public class SchedulerDAOImpl implements SchedulerDAO {
	
	@Autowired(required=true)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getTaskList() {
		List<Task> taskList = new ArrayList<Task>();
		Session session =  sessionFactory.openSession();
		taskList =  session.createCriteria(Task.class).list();
		session.close();
		return taskList;
	}

	@Override
	public void createTask(Task taskToSave) {
		Session session  = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(taskToSave);
		tx.commit();
		session.close();
		
	}

	
	
	
}
