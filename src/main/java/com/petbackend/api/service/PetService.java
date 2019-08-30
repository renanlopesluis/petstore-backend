package com.petbackend.api.service;

import java.util.List;

import com.petbackend.api.enums.BathTypeEnum;
import com.petbackend.api.enums.HairTypeEnum;
import com.petbackend.api.model.Pet;

public interface PetService {
	
	void addPet(Pet pet);
	void remove(Pet pet);
	List<Pet> getPets();
	void doBath(Pet pet, BathTypeEnum bathType) throws ClassNotFoundException ;
	void doHair(Pet pet, HairTypeEnum hairType)throws ClassNotFoundException;
	List<Pet> searchByAge(Integer age);

}
