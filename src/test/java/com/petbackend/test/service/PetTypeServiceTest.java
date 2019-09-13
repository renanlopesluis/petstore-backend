package com.petbackend.test.service;


import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.petbackend.api.model.PetType;
import com.petbackend.api.service.PetTypeService;
import com.petbackend.test.dataprovider.PetTypeDataProvider;

@RunWith(SpringRunner.class)
@SpringBootApplication
@EntityScan(basePackages ={"com.petbackend.api.model"})
@EnableJpaRepositories(basePackages ={"com.petbackend.api.repository"})
@ComponentScan(basePackages ={"com.petbackend.api.service", "com.petbackend.test.dataprovider"})
public class PetTypeServiceTest {
	
	@Autowired
	private PetTypeService service;
	
	@Autowired
	private PetTypeDataProvider dataProvider;
	
	@Before
	public void setUp() {
		dataProvider.cleanAll();
	}
	
	@After
	public void clear() {
		setUp();
	}
		
	@Test
	public void shouldInsertAPetType(){
		PetType petType = dataProvider.build();
		
		Assert.assertNotNull(petType.getId());		
	}
	
	@Test
	public void shouldListPetTypes(){
		dataProvider.build();
		List<PetType> petTypes = service.getPetTypes();
		
		Assert.assertNotNull(petTypes);
		Assert.assertEquals(petTypes.isEmpty(), false);
		Assert.assertEquals(petTypes.size(), 1);
	}
	
	@Test
	public void shouldFindAPetTypeById(){
		PetType petType = dataProvider.build();
		
		Assert.assertEquals(service.findById(petType.getId()).isPresent(), true);	
	}

	@Test
	public void shouldRemoveAPetType(){
		PetType petType = dataProvider.build();
		service.remove(petType);
		
		Assert.assertEquals(service.findById(petType.getId()).isPresent(), false);	
	}
}
