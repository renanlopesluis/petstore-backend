package com.petbackend.api.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.petbackend.api.model.Pet;

@Service
@Qualifier("dryBathService")
public class DryBathService extends BathService{

	@Override
	public void execute(Pet pet) {
		System.out.println("The Pet "+pet.getName()+" took a dry bath");
	}

}
