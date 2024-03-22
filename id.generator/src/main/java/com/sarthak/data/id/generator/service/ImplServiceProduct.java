package com.sarthak.data.id.generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.data.id.generator.dao.DaoProductPersistent;
import com.sarthak.data.id.generator.entity.Product;

@Service
public class ImplServiceProduct implements ISeriveProduct {
	@Autowired
	private DaoProductPersistent daoProductPersistent;
	@Override
	public Product saveAndFlush(Product entity) {
		if(entity!=null)
			return daoProductPersistent.saveAndFlush(entity);
		return null;
	}

	@Override
	public Product getReferenceById(Integer id) {
		if(id!=null)
			return daoProductPersistent.getReferenceById(id);
		return null;
	}

}
