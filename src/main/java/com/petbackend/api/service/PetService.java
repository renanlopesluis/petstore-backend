package com.petbackend.api.service;

import java.util.List;
import java.util.Optional;

import com.petbackend.api.enums.BathTypeEnum;
import com.petbackend.api.enums.HairTypeEnum;
import com.petbackend.api.model.Pet;

public interface PetService {
	
	Pet save(Pet pet);
	Optional<Pet> findById(Long id);
	List<Pet> findByName(String name);
	void remove(Pet pet);
	List<Pet> getPets();
	void doBath(Pet pet, BathTypeEnum bathType) throws ClassNotFoundException ;
	void doHair(Pet pet, HairTypeEnum hairType)throws ClassNotFoundException;
	List<Pet> findByAge(Integer age);

}
