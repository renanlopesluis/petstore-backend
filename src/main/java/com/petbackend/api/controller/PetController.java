package com.petbackend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.petbackend.api.builder.PetBuilder;
import com.petbackend.api.builder.PetTypeBuilder;
import com.petbackend.api.model.Pet;
import com.petbackend.api.model.PetType;
import com.petbackend.api.module.PetServiceModule;
import com.petbackend.api.service.PetService;

@RestController
@RequestMapping("pet")
public class PetController {

	PetService service;
	
	public PetController() {
		Injector injector = Guice.createInjector(new PetServiceModule());
		service = injector.getInstance(PetService.class);
	}
	
	@CrossOrigin
	@RequestMapping(value="listPets", method = RequestMethod.GET)
	public @ResponseBody List<Pet> retrieveAllPets(){
		service.getPets().clear();
		PetType dog = PetTypeBuilder.build(1, "dog");
		PetType cat = PetTypeBuilder.build(2, "cat");
		service.addPet(PetBuilder.build(1, "Alvin", dog, 1));
		service.addPet(PetBuilder.build(2, "Dominique", cat, 8));
		return service.getPets();
	}
}
