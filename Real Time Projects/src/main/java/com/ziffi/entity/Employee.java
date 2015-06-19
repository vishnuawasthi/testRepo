/**
 * 
 */
package com.ziffi.entity;

import java.io.Serializable;

/**
 * @author vawasthi
 *
 */
public class Employee extends AllBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6104204112742927868L;
	private String id;
	private String name;
	private String dept;
	
	public Employee() {
		super();
	}
	
	public Employee(String id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
