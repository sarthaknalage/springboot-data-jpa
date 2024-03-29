package com.spring.jpa.sarthak.custom.query.jpql.persisten.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.sarthak.custom.query.jpql.model.Customer;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

public interface InterCutomerPersistent extends JpaRepository<Customer,Integer> {
	
//	customer JPQL Query for getting required details only of the customer
	@Query(value = "select custName, custMobNumber from Customer", nativeQuery = false)
	List<Object[]> getPartilaCustomerDetails();
// get List of Customer Partial details with having id greater than 4 with native sql query
	@Query(value = "select cust_name ,cust_mob from customer where cust_id>:id", nativeQuery = true)
	List<Object[]> getCustomerDetailsGreaterID(Integer id);
	
	@Query(value = "from Customer where custId=?1", nativeQuery = false)
	Customer getListOfCustomerIndexId(Integer id);
	
	@Query(value = "update Customer c set c.custEmail=?2 where c.custId=?1", nativeQuery = false)
	@Modifying(flushAutomatically = true)
	@Transactional(value=TxType.REQUIRED)
	Integer updateCustomer(Integer id,String mail);
}
