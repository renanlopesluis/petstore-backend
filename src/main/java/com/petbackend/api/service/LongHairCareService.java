package com.petbackend.api.service;

import com.petbackend.api.model.Pet;

public class LongHairCareService extends HairCareService{

	@Override
	public void execute(Pet pet) {
		System.out.println("The pet "+pet.getName()+" has got its long hair perfectly cared");
	}

}
