/**
 * 
 */
package com.ziffi.service.impl;

import java.util.List;

import com.ziffi.entity.Task;

/**
 * @author vawasthi
 *
 */
public interface SchedulerService {
	public abstract List<Task> getTaskList();
	public abstract void createTask(Task taskToSave);
	
}
