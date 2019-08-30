package com.petbackend.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.petbackend.api.enums.BathTypeEnum;
import com.petbackend.api.enums.HairTypeEnum;
import com.petbackend.api.factory.BathFactory;
import com.petbackend.api.factory.HairCareFactory;
import com.petbackend.api.model.Pet;

public class PetServiceImpl implements PetService{
	
	
	private List<Pet> pets = new ArrayList<Pet>();
	
	private Service service;

	@Override
	public void addPet(Pet pet) {
		pets.add(pet);
	}

	@Override
	public void remove(Pet pet) {
		pets.remove(pet);	
	}

	@Override
	public void doBath(Pet pet, BathTypeEnum bathType) throws ClassNotFoundException {
		service = BathFactory.getInstance(bathType);
		service.execute(pet);
	}
	
	@Override
	public void doHair(Pet pet, HairTypeEnum hairType) throws ClassNotFoundException {
		service = HairCareFactory.getInstance(hairType);
		service.execute(pet);
	}

	@Override
	public List<Pet> searchByAge(Integer age) {
		return pets.stream().filter(p->
			p.getAge().equals(age)).collect(Collectors.toList());
	}

	@Override
	public List<Pet> getPets() {
		return this.pets;
	}

}
