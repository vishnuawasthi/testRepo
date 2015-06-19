/**
 * 
 */
package com.valuelabs.test;

import java.util.Comparator;	


/**
 * @author vawasthi
 * @param <T>
 *
 */
public class SavingsCalculatorDTO implements Comparator<SavingsCalculatorDTO> {
	
	private String getCategory;
	

	public String getGetCategory() {
		return getCategory;
	}


	public void setGetCategory(String getCategory) {
		this.getCategory = getCategory;
	}


	/**
	 * This method is for sorting the list of element basis of category
	 */
	@Override
	public int compare(SavingsCalculatorDTO savingsCalculatorDTOParam1,
			SavingsCalculatorDTO savingsCalculatorDTOParam2) {
		return (savingsCalculatorDTOParam1.getGetCategory().toString().compareTo(
				savingsCalculatorDTOParam2.getGetCategory().toString()) > 0) ? 1 :-1;
		
	}
}
