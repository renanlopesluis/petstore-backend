package com.petbackend.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petbackend.api.model.Pet;
import com.petbackend.api.service.PetService;

@CrossOrigin
@RestController
@RequestMapping("petstore")
public class PetController {

	@Autowired
	@Qualifier("petServiceImpl")
	PetService service;
		
	@RequestMapping(value="pet", method = RequestMethod.GET)
	public @ResponseBody List<Pet> retrieveAllPets(){
		return service.getPets();
	}
	
	@RequestMapping(value="pet", method = RequestMethod.POST)
	public @ResponseBody Pet addPet(@Valid @RequestBody Pet pet){
		return service.save(pet);
	}
}
