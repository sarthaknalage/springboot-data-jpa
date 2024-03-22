package com.sarthak.data.id.generator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.data.id.generator.entity.Product;

@Repository
public interface DaoProductPersistent extends JpaRepository<Product,Integer> {

}
