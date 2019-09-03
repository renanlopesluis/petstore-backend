package com.petbackend.api.builder;

import org.springframework.stereotype.Component;

import com.petbackend.api.dto.PetDTO;

@Component
public class PetDTOBuilder {
	
	public static PetDTO build(Long id, String name, String type, Integer age) {
		return PetDTO.builder().id(id).name(name).type(type).age(age).build();
	}
}
