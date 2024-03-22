package com.sarthak.data.jpa.basicMethods.operations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer custId;
	
	@Column(name = "cust_name")
	private String custName;
	
	@Column(name = "cust_mob")
	private Long custMobNumber;
	
	@Column(name ="cust_mail")
	private String custEmail;
	
	public Customer() {
		
	}

	public Customer(String custName, Long custMobNumber, String custEmail) {
		super();
		this.custName = custName;
		this.custMobNumber = custMobNumber;
		this.custEmail = custEmail;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getCustMobNumber() {
		return custMobNumber;
	}

	public void setCustMobNumber(Long custMobNumber) {
		this.custMobNumber = custMobNumber;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custMobNumber=" + custMobNumber
				+ ", custEmail=" + custEmail + "]";
	}
	
	
	
}
