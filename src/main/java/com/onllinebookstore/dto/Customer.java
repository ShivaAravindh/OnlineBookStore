package com.onllinebookstore.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	public void setCustomerphn(long customerphn) {
		this.customerphn = customerphn;
	}

	public void setCustomerpass(String customerpass) {
		this.customerpass = customerpass;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cusId;
	private String customerName;
	private String customeremail;
	private long customerphn;
	private String customerpass;
	
	
	public Customer(String customerName, String customeremail, long customerphn, String customerpass) {
		super();
		
		this.customerName = customerName;
		this.customeremail = customeremail;
		this.customerphn = customerphn;
		this.customerpass = customerpass;
	}

	public String getCustomeremail() {
		return customeremail;
	}

	public String getCustomerpass() {
		return customerpass;
	}


	public int getId() {
		return cusId;
	}

	

	public String getCustomerName() {
		return customerName;
	}

	

	public long getCustomerphn() {
		return customerphn;
	}

	

	



	

	
}
