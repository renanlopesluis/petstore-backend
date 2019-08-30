package com.petbackend.api.builder;

import com.petbackend.api.model.PetType;

public class PetTypeBuilder {

	public static PetType build(Integer id, String description) {
		return PetType.builder().id(id).description(description).build();
	}
}
