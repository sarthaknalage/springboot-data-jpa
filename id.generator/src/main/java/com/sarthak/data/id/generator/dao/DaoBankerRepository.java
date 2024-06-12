package com.sarthak.data.id.generator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarthak.data.id.generator.entity.Banker;

@Repository
public interface DaoBankerRepository extends JpaRepository<Banker, String> {

}
