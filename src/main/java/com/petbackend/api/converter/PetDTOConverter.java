package com.petbackend.api.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.petbackend.api.builder.PetDTOBuilder;
import com.petbackend.api.dto.PetDTO;
import com.petbackend.api.model.Pet;

@Component
@Qualifier("petDTOConverter")
public class PetDTOConverter implements Converter<Pet, PetDTO> {

	@Override
	public PetDTO convert(Pet pet) throws IllegalArgumentException {
		return PetDTOBuilder
				.build(pet.getId(), 
						pet.getName(), 
						pet.getType().getDescription(), 
						pet.getAge());
	}

	@Override
	public List<PetDTO> convert(List<Pet> pets) throws IllegalArgumentException {
		List<PetDTO> petsDTO = new ArrayList<>();
		pets.stream().forEach(pet -> petsDTO.add(convert(pet)));
		return petsDTO;
	}

}
