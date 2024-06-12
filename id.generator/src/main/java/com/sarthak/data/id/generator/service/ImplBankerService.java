package com.sarthak.data.id.generator.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarthak.data.id.generator.dao.DaoBankerRepository;
import com.sarthak.data.id.generator.entity.Banker;

@Service
public class ImplBankerService implements InterBankerService {
	@Autowired
	DaoBankerRepository bankerRepository;

	@Override
	public Banker saveAndFlush(Banker entity) {
		Banker savedEntity=bankerRepository.saveAndFlush(entity);
		return savedEntity;
	}

	@Override
	public Banker findById(String id) {
		Optional<Banker> fetchedBanker=bankerRepository.findById(id);
		return fetchedBanker.isPresent()?fetchedBanker.get():null;
	}

}
