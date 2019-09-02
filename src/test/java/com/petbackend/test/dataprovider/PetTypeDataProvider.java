package com.petbackend.test.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Component;

import com.petbackend.api.builder.PetTypeBuilder;
import com.petbackend.api.model.PetType;
import com.petbackend.api.repository.PetTypeRepository;

@Component
@DataJpaTest
public class PetTypeDataProvider {

	private PetTypeRepository repository;

	@Autowired
    public PetTypeDataProvider(PetTypeRepository repository) {
        this.repository = repository;
    }
	
	public PetType build() {
		PetType petType = PetTypeBuilder.build(null, "Dog");
        return this.repository.save(petType);
    }
    
    public void deleteAll() {
		this.repository.deleteAll();
	}
}