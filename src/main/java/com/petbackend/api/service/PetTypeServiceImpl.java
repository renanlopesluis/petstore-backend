package com.petbackend.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.petbackend.api.model.PetType;
import com.petbackend.api.repository.PetTypeRepository;

@Service
@Qualifier("petTypeServiceImpl")
public class PetTypeServiceImpl implements PetTypeService {

	@Autowired
	private PetTypeRepository repository;
	
	@Override
	public PetType save(PetType type) {
		return repository.save(type);
	}

	@Override
	public void remove(PetType type) {
		repository.delete(type);
	}

	@Override
	public List<PetType> getPetTypes() {
		return repository.findAll();
	}

	@Override
	public Optional<PetType>  findById(Long id) {
		return this.repository.findById(id);
	}	
}
