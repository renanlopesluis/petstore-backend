package com.petbackend.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petbackend.api.model.PetType;
import com.petbackend.api.service.PetTypeService;

@CrossOrigin
@RestController
@RequestMapping("petstore")
public class PetTypeController {
	
	@Autowired
	@Qualifier("petTypeServiceImpl")
	PetTypeService service;
		
	@RequestMapping(value="petType", method = RequestMethod.GET)
	public @ResponseBody List<PetType> retrieveAllPetTypes(){
		return service.getPetTypes();
	}
}
