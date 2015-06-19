/**
 * 
 */
package com.ziffi.service.impl;

import java.util.List;

/**
 * @author vawasthi
 *
 */
public interface HibernateOperationsService<T> {
	public abstract boolean validateUser(T objectTosave);
	public abstract void save(T objectToSave);
	public abstract void delete(T objectToDelete);
	public abstract void update(T objectToUpdate);
	public abstract List<T> list();
}
