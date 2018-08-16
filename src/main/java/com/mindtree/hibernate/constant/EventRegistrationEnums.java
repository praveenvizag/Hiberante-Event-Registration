package com.mindtree.hibernate.constant;

/**
 * enum hold the constants
 * @author M1043827
 *
 */
public enum EventRegistrationEnums {
	M100100("M100100"),
	M100108("M100108"),
	M100189("M100189"),
	M101190("M101190");
	
	private String mid;
	
	 public String getMid() {
		 return mid;
		 
	 }

	EventRegistrationEnums(String mid) {
		this.mid = mid;
	}
	 
	 

}
