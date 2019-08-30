package com.petbackend.api.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.petbackend.api.model.Pet;

@Service
@Qualifier("perfumefulBathService")
public class PerfumefulBathService extends BathService{
	
	@Override
	public void execute(Pet pet) {
		System.out.println("The Pet "+pet.getName()+" took a perfume bath");
	}
}
