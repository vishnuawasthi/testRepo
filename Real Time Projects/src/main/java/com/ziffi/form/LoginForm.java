/**
 * 
 */
package com.ziffi.form;

import java.io.Serializable;

/**
 * @author vawasthi
 *
 */
public class LoginForm implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7222175410970700475L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
