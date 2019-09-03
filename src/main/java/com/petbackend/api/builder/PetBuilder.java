package com.petbackend.api.builder;

import org.springframework.stereotype.Component;

import com.petbackend.api.model.Pet;
import com.petbackend.api.model.PetType;

@Component
public class PetBuilder {
	
	public static Pet build(Long id, String name, PetType type, Integer age) {
		return Pet.builder().id(id).name(name).type(type).age(age).build();
	}

}
