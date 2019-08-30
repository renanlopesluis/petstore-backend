package com.petbackend.api.service;

import java.util.List;

import com.petbackend.api.model.PetType;

public interface PetTypeService {

	PetType save(PetType type);
	void remove(PetType type);
	List<PetType> getPetTypes();
}
