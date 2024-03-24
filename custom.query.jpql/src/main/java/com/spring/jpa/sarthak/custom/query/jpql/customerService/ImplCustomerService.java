package com.spring.jpa.sarthak.custom.query.jpql.customerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.sarthak.custom.query.jpql.persisten.customer.InterCutomerPersistent;

@Service
public class ImplCustomerService implements InterCustomerService {
	@Autowired
	private InterCutomerPersistent interCustomerPersistent;
	@Override
	public List<Object[]> getCustomerPartilaDetails() {
		return this.interCustomerPersistent.getPartilaCustomerDetails();
	}
	@Override
	public List<Object[]> getCustomerDetailsGreaterID(Integer id) {
		return this.interCustomerPersistent.getCustomerDetailsGreaterID(id);
	}

}
