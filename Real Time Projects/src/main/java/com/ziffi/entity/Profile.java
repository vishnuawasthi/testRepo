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
@Table(name = "doctors_profile")
public class Profile extends BaseEntity  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3935658110120231986L;
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "photo_path")
	private String photoPath;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}
	/**
	 * @param photoPath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	

}
