package com.petbackend.api.builder;

import org.springframework.stereotype.Component;

import com.petbackend.api.model.PetType;

@Component
public class PetTypeBuilder {

	public static PetType build(Long id, String description) {
		return PetType.builder().id(id).description(description).build();
	}
}
