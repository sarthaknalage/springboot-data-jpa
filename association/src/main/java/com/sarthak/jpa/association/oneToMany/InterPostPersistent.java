package com.sarthak.jpa.association.oneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "postRepository")
public interface InterPostPersistent extends JpaRepository<Post, Integer> {

}
