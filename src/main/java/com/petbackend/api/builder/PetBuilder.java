package com.petbackend.api.builder;

import com.petbackend.api.model.Pet;
import com.petbackend.api.model.PetType;

public class PetBuilder {
	
	public static Pet build(Integer id, String name, PetType type, Integer age) {
		return Pet.builder().id(id).name(name).type(type).age(age).build();
	}

}