package com.spring.jpa.sarthak.custom.query.jpql.customerService;

import java.util.List;

import com.spring.jpa.sarthak.custom.query.jpql.model.Customer;

public interface InterCustomerService {
	
	public List<Object[]> getCustomerPartilaDetails();
	List<Object[]> getCustomerDetailsGreaterID(Integer id);
	Customer getListOfCustomerIndexId(Integer id);
	Integer updateCustomer(Integer id,String mail);
}
