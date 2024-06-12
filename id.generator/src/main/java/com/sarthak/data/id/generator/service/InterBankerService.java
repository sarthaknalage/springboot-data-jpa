package com.sarthak.data.id.generator.service;

import com.sarthak.data.id.generator.entity.Banker;

public interface InterBankerService {

	Banker saveAndFlush(Banker entity);

	Banker findById(String id);

}
