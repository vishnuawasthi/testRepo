/**
 * 
 */
package com.valuelabs.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author vawasthi
 *
 */
public class RegularExpressionTest {

	public static void main(String args[]){
		
		
		System.out.println(isValidPhone("(1111111111)"));
	}
	
	
	
	public static boolean isValideMobile(String phone){
		String regex = "[0-9]{10}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();		
	}
	
	
	public static boolean isValidPhone(String phone){
		//String regex = "[0-9-() ]*$" ;
		
		//String regex = " /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/";
		String regex = "^\\(?(\\d{3})\\)?[-. ]?(\\d{3})[-. ]?(\\d{4})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();		
		
	}

}
