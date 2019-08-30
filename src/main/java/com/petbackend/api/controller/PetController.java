package com.petbackend.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.petbackend.api.model.Pet;
import com.petbackend.api.module.PetServiceModule;
import com.petbackend.api.service.PetService;

@CrossOrigin
@RestController
@RequestMapping("petstore")
public class PetController {

	PetService service;
	
	public PetController() {
		Injector injector = Guice.createInjector(new PetServiceModule());
		service = injector.getInstance(PetService.class);
	}
	
	@RequestMapping(value="pet", method = RequestMethod.GET)
	public @ResponseBody List<Pet> retrieveAllPets(){
		return service.getPets();
	}
	
	@RequestMapping(value="pet", method = RequestMethod.POST)
	public @ResponseBody Pet addPet(@Valid @RequestBody Pet pet){
		pet.setId(service.getPets().size()+1);
		service.getPets().add(pet);
		return pet;
	}
}
