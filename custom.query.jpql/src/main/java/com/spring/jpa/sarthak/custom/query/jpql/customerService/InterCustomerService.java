package com.spring.jpa.sarthak.custom.query.jpql.customerService;

import java.util.List;

public interface InterCustomerService {
	
	public List<Object[]> getCustomerPartilaDetails();
	List<Object[]> getCustomerDetailsGreaterID(Integer id);
}
