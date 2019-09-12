package com.petbackend.api.service;

import java.util.List;
import java.util.Optional;

import com.petbackend.api.model.PetType;

public interface PetTypeService {

	PetType save(PetType type);
	Optional<PetType> findById(Long id);
	void remove(PetType type);
	List<PetType> getPetTypes();
}
