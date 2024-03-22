package com.sarthak.data.jpa.basicMethods.operations.persistent;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.data.jpa.basicMethods.operations.model.Customer;

@Repository
public interface CustomerPersistent extends ListCrudRepository<Customer,Integer>, ListPagingAndSortingRepository<Customer,Integer> {
//	powerful finder method of spring data jpa without using the primary key as finding attribute.
	Iterable<Customer> findByCustName(String custName);
//	use JPA query to get list of customers with customer name and mobile number
	@Query(value = "select custName as Name,custMobNumber as Mobile from Customer c where c.custId>:id", nativeQuery= false)
	public List<Object[]> getCustomerList(Integer id);
}