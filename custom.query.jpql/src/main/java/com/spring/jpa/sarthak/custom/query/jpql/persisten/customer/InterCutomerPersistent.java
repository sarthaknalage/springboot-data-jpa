package com.spring.jpa.sarthak.custom.query.jpql.persisten.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.sarthak.custom.query.jpql.model.Customer;

public interface InterCutomerPersistent extends JpaRepository<Customer,Integer> {
	
//	customer JPQL Query for getting required details only of the customer
	@Query(value = "select custName, custMobNumber from Customer", nativeQuery = false)
	List<Object[]> getPartilaCustomerDetails();
// get List of Customer Partial details with having id greater than 4 with native sql query
	@Query(value = "select cust_name ,cust_mob from customer where cust_id>:id", nativeQuery = true)
	List<Object[]> getCustomerDetailsGreaterID(Integer id);
	
}
