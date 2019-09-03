package com.petbackend.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petbackend.api.converter.Converter;
import com.petbackend.api.dto.PetDTO;
import com.petbackend.api.dto.PetServiceDTO;
import com.petbackend.api.enums.BathTypeEnum;
import com.petbackend.api.enums.HairTypeEnum;
import com.petbackend.api.model.Pet;
import com.petbackend.api.service.PetService;


@CrossOrigin
@RestController
@RequestMapping("petstore")
public class PetController {

	@Autowired
	@Qualifier("petServiceImpl")
	private PetService service;
	
	@Autowired
	@Qualifier("petDTOConverter")
	private Converter<Pet, PetDTO> converter;

	@RequestMapping(value = "pet", method = RequestMethod.GET)
	public @ResponseBody List<PetDTO> retrieveAllPets() {
		try {
			return converter.convert(service.getPets());
		}catch(IllegalArgumentException iae){
			return new ArrayList<>();
		}
	}

	@RequestMapping(value = "pet", method = RequestMethod.POST)
	public @ResponseBody Pet addPet(@Valid @RequestBody Pet pet) {
		return service.save(pet);
	}

	@RequestMapping(value = "bath", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> doBath(@RequestParam("petId") Long petId,
			@RequestParam("bathCode") Integer bathCode) {
		try {
			Pet pet = service.findById(petId);
			BathTypeEnum bathType = BathTypeEnum.getByCode(bathCode).get();
			service.doBath(pet, bathType);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new PetServiceDTO("The pet "+pet.getName()+" has had an awesome " + bathType.getDescription() + "!"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@RequestMapping(value = "hair", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> doHair(@RequestParam("petId") Long petId, @RequestParam("hairCode") Integer hairCode) {
		try {
			Pet pet = service.findById(petId);
			HairTypeEnum hairType = HairTypeEnum.getByCode(hairCode).get();
			service.doHair(pet, hairType);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new PetServiceDTO("he pet "+pet.getName()+" has had its " +hairType.getDescription() + " cut!"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
