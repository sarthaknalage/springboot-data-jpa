package com.sarthak.data.jpa.basicMethods.operations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sarthak.data.jpa.basicMethods.operations.model.Customer;

public interface CustomerServiceInterface {
	
//	Here add all the Required logic methods abstraction level implementation
	
//	save all the list of customers
	List<Customer> saveAll(Iterable<Customer> entities);
	
	Customer save(Customer entity);

	List<Customer> findAll();
	
	List<Customer> findAllById(Iterable<Integer> ids);
	
	
	Optional<Customer> findById(Integer id);
	
	void deleteAllById(Iterable<Integer> ids);

	long count();
	
	//paging and sorting methods
	List<Customer> findAll(Sort sort);
	
	Page<Customer> findAll(Pageable pageable);
	
	Iterable<Customer> getCustomerByName(String custName);
	
	public List<Object[]> getCustomerList(Integer id);
	
	
	
	
	
	
	
}
