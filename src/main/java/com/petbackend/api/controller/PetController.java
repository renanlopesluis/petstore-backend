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
import com.petbackend.api.dto.PetServiceRequestBodyDTO;
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

	@RequestMapping(value = "pets", method = RequestMethod.GET)
	public @ResponseBody List<PetDTO> retrieveAllPets() {
		try {
			return converter.convert(service.getPets());
		}catch(IllegalArgumentException iae){
			return new ArrayList<>();
		}
	}

	@RequestMapping(value = "pet", method = RequestMethod.POST)
	public @ResponseBody PetDTO savePet(@Valid @RequestBody Pet pet) {
		return converter.convert(service.save(pet));
	}
	
	@RequestMapping(value = "pet", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePet(@RequestParam("id") Long id) {
		try {
			service.remove(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new PetServiceDTO("Pet successfully removed!"));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@RequestMapping(value = "pet", method = RequestMethod.GET)
	public ResponseEntity<PetDTO> findPetById(@RequestParam("id") Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(converter.convert(service.findById(id).get()));
		}catch(IllegalArgumentException e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@RequestMapping(value = "searchPet", method = RequestMethod.GET)
	public @ResponseBody List<PetDTO> findPetByName(@RequestParam("name") String name) {
		try {
			return converter.convert(service.findByName(name));
		}catch(IllegalArgumentException iae){
			return new ArrayList<>();
		}
	}

	@RequestMapping(value = "bath", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> doBath(@RequestBody PetServiceRequestBodyDTO requestBody) {
		try {
			Pet pet = service.findById(requestBody.getPetId()).get();
			BathTypeEnum bathType = BathTypeEnum.getByCode(requestBody.getServiceCode()).get();
			service.doBath(pet, bathType);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new PetServiceDTO("The pet "+pet.getName()+" has had an awesome " + bathType.getDescription().toLowerCase() + "!"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@RequestMapping(value = "hair", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> doHair(@RequestBody PetServiceRequestBodyDTO requestBody) {
		try {
			Pet pet = service.findById(requestBody.getPetId()).get();
			HairTypeEnum hairType = HairTypeEnum.getByCode(requestBody.getServiceCode()).get();
			service.doHair(pet, hairType);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new PetServiceDTO("The pet "+pet.getName()+" has had its " +hairType.getDescription().toLowerCase() + " cut!"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
