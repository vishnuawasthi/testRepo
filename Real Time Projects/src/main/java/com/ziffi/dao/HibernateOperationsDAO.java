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
public interface HibernateOperationsDAO<T> {
	public abstract boolean validateUser(T objectTosave);
	public abstract void save(T objectToSave);
	public abstract void delete(T objectToDelete);
	public abstract void update(T objectToUpdate);
	public abstract List<T> list();
	

}
