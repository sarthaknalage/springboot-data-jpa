package com.sarthak.data.jpa.basicMethods.operations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sarthak.data.jpa.basicMethods.operations.model.Customer;
import com.sarthak.data.jpa.basicMethods.operations.persistent.CustomerPersistent;

@Service
public class ImplCustomerService implements CustomerServiceInterface{
	@Autowired
	CustomerPersistent customerPersistent;
	
	@Override
	public List<Customer> saveAll(Iterable<Customer> entities) {
		
		return (entities!=null? customerPersistent.saveAll(entities):null);
	}

	@Override
	public Customer save(Customer entity) {
		// TODO Auto-generated method stub
		return (entity!=null)?customerPersistent.save(entity):null;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> list= customerPersistent.findAll();
		return (list!=null && list.size()>0)?list:null;
	}

	@Override
	public List<Customer> findAllById(Iterable<Integer> ids) {
		List<Integer> list=(List<Integer>)ids;
		return(ids!=null)?customerPersistent.findAllById(ids):null;
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		return customerPersistent.count();
	}

	@Override
	public List<Customer> findAll(Sort sort) {
		return (sort!=null)?customerPersistent.findAll(sort):null;
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return (pageable!=null)?customerPersistent.findAll(pageable):null;
	}

	@Override
	public Iterable<Customer> getCustomerByName(String custName) {
		Iterable<Customer> iterable=null;
		if(custName!=null) {
			iterable=customerPersistent.findByCustName(custName);
		}
		return iterable;
	}

	@Override
	public List<Object[]> getCustomerList(Integer id) {
		return(id!=null)?this.customerPersistent.getCustomerList(id):null;
	}

}