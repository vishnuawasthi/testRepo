/**
 * 
 */
package com.valuelabs.test;

import java.util.Scanner;

/**
 * @author vawasthi
 *
 */
public class CustomExceptionTest {

	public static void main(String args[]) throws NumberNotFoundException{
		Scanner s = new Scanner(System.in);
		Integer number = s.nextInt();
		if(!number.equals(10)){
			throw new  NumberNotFoundException("Number not found");
		}else{
			System.out.println("Number found"+number);
		}
	}
}
