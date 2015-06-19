/**
 * 
 */
package com.ziffi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author vawasthi
 *
 */
@Entity
@Table(name="media")
public class Media implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id ")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="path")
	private String path;
	@Column(name="reference_id")
	private Integer referenceID;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getReferenceID() {
		return referenceID;
	}
	public void setReferenceID(Integer referenceID) {
		this.referenceID = referenceID;
	}
	

}
