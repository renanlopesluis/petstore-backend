package com.petbackend.test.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petbackend.api.model.Pet;
import com.petbackend.api.repository.PetRepository;

@Component
public class PetDataProvider {
	
	@Autowired
	private PetRepository repository;
	
	@Autowired
	private PetTypeDataProvider petTypeDataProvider;
	
	public Pet build() {
        return repository.save(
        		repository.save(
        				Pet.builder()
        					.name("Alvin")
        					.age(1)
        					.type(petTypeDataProvider
        							.build()).build()));
    }
	
    public void cleanAll() {
    	repository.deleteAll();
    	petTypeDataProvider.cleanAll();
    }

}
