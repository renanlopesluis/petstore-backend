package com.petbackend.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.petbackend.api.enums.BathTypeEnum;
import com.petbackend.api.enums.HairTypeEnum;
import com.petbackend.api.factory.BathFactory;
import com.petbackend.api.factory.HairCareFactory;
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
	public Pet findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void remove(Pet pet) {
		repository.delete(pet);	
	}

	@Override
	public void doBath(Pet pet, BathTypeEnum bathType) throws ClassNotFoundException {
		BathFactory.getInstance(bathType).execute(pet);
	}
	
	@Override
	public void doHair(Pet pet, HairTypeEnum hairType) throws ClassNotFoundException {
		HairCareFactory.getInstance(hairType).execute(pet);
	}

	@Override
	public List<Pet> searchByAge(Integer age) {
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
