/**
 * 
 */
package com.ziffi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziffi.dao.SchedulerDAO;
import com.ziffi.entity.Task;

/**
 * @author vawasthi
 *
 */
@Service("SchedulerService")
public class SchedulerServiceImpl implements SchedulerService {
	
	@Autowired
	private SchedulerDAO  schedulerDAO;
	
	@Override
	public List<Task> getTaskList() {
		return schedulerDAO.getTaskList();
	}

	@Override
	public void createTask(Task taskToSave) {
		schedulerDAO.createTask(taskToSave);		
	}

}
