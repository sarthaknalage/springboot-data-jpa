package com.sarthak.jpa.association.oneToOne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="repoMapping1")
public interface InterRepositoryMapping1 extends JpaRepository<LoginDetail, Integer>{

}
