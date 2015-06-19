/**
 * 
 */
package com.ziffi.entity;

import java.io.Serializable;

/**
 * @author vawasthi
 *
 */
public class AllBase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6978309893919829745L;
	private Object success;
	private Object error;
	public Object getSuccess() {
		return success;
	}
	public void setSuccess(Object success) {
		this.success = success;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	
	
	
	

}
