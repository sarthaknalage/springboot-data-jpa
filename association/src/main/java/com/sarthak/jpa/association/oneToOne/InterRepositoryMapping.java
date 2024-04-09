package com.sarthak.jpa.association.oneToOne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "repoMapping")
public interface InterRepositoryMapping extends JpaRepository<Student,Integer> {

}
