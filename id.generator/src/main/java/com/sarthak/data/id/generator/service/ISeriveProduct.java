package com.sarthak.data.id.generator.service;

import com.sarthak.data.id.generator.entity.Product;

public interface ISeriveProduct {
	
	Product saveAndFlush(Product entity);
	
	Product getReferenceById(Integer id);
}
