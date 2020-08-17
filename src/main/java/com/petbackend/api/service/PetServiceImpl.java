package com.petbackend.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.petbackend.api.enums.BathTypeEnum;
import com.petbackend.api.enums.HairTypeEnum;
import com.petbackend.api.strategy.BathStrategy;
import com.petbackend.api.strategy.HairCareStrategy;
import com.petbackend.api.model.Pet;
import com.petbackend.api.repository.PetRepository;

@Service
@Qualifier("petServiceImpl")
public class PetServiceImpl implements PetService{
				
	@Autowired
	private PetRepository repository;
	
	@Override
	public Pet save(Pet pet) {
		return repository.save(pet);
	}
	
	@Override
	public Optional<Pet> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void doBath(Pet pet, BathTypeEnum bathType) throws ClassNotFoundException {
		BathStrategy.getInstance(bathType).execute(pet);
	}
	
	@Override
	public void doHair(Pet pet, HairTypeEnum hairType) throws ClassNotFoundException {
		HairCareStrategy.getInstance(hairType).execute(pet);
	}

	@Override
	public List<Pet> findByAge(Integer age) {
		return repository.findByAge(age);
	}

	@Override
	public List<Pet> getPets() {
		return repository.findAll();
	}

	@Override
	public List<Pet> findByName(String name) {
		return repository.findByNameContaining(name);
	}
}
