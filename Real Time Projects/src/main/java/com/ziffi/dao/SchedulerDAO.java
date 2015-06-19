/**
 * 
 */
package com.ziffi.dao;

import java.util.List;

import com.ziffi.entity.Task;

/**
 * @author vawasthi
 *
 */
public interface SchedulerDAO {
	public abstract List<Task> getTaskList();
	public abstract void createTask(Task taskToSave);
}
