/**
 * 
 */
package com.ziffi.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author vawasthi
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class LoginResponse implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9152364014593433776L;
	private String success;
	private String error;
	public LoginResponse(){
		
	}
	public LoginResponse(String success,String error){
		this.success=success;
		this.error=error;
	}
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
