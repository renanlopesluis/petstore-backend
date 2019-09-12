package com.petbackend.test.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petbackend.api.model.PetType;
import com.petbackend.api.repository.PetTypeRepository;

@Component
public class PetTypeDataProvider {
	
	@Autowired
	private PetTypeRepository repository;  

    public PetType build() {
        return repository.save(PetType.builder().description("Dog").build());
    }
    
    public void cleanAll() {
    	repository.deleteAll();
    }
   
}
