package com.petbackend.api.service;

import com.petbackend.api.model.Pet;

public class WaterBathService extends BathService{
	
	@Override
	public void execute(Pet pet) {
		System.out.println("The Pet "+pet.getName()+" took a dry bath");
	}
}
