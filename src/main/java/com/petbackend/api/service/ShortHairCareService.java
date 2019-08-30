package com.petbackend.api.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.petbackend.api.model.Pet;

@Service
@Qualifier("shortHairCareService")
public class ShortHairCareService extends HairCareService{

	@Override
	public void execute(Pet pet) {
		System.out.println("The pet "+pet.getName()+" has got its short hair perfectly cared");
	}

}
