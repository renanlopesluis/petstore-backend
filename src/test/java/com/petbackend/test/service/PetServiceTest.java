package com.petbackend.test.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.petbackend.api.model.Pet;
import com.petbackend.api.service.PetService;
import com.petbackend.test.dataprovider.PetDataProvider;

@RunWith(SpringRunner.class)
@SpringBootApplication
@EntityScan(basePackages ={"com.petbackend.api.model"})
@EnableJpaRepositories(basePackages ={"com.petbackend.api.repository"})
@ComponentScan(basePackages ={"com.petbackend.api.service", "com.petbackend.test.dataprovider"})
public class PetServiceTest {
	
	@Autowired 
	@Qualifier("petServiceImpl")
	private PetService service;
		
	@Autowired
	private PetDataProvider dataProvider;
	

	@Before
	public void setUp() {
		dataProvider.cleanAll();
	}

	@Test
	public void shouldInsertAPetType(){
		Pet pet = dataProvider.build();
		Assert.assertNotNull(pet.getId());		
	}
	
	@Test
	public void shouldListPets(){
		dataProvider.build();
		
		Assert.assertNotNull(service.getPets());
		Assert.assertEquals(service.getPets().isEmpty(), false);	
	}
	
	@Test
	public void shouldFindAPetById(){
		Pet pet = dataProvider.build();
		Assert.assertEquals(service.findById(pet.getId()).isPresent(), true);	
	}
	
	@Test
	public void shouldFindPetsByName(){
		Pet pet = dataProvider.build();
		Assert.assertNotNull(service.findByName(pet.getName()));	
	}
	
	@Test
	public void shouldFindPetsByAge(){
		Pet pet = dataProvider.build();
		Assert.assertNotNull(service.findByAge(pet.getAge()));	
	}

	@Test
	public void shouldRemoveAPet(){
		Pet pet = dataProvider.build();
		service.remove(pet);
		Assert.assertEquals(service.findById(pet.getId()).isPresent(), false);	
	}
	
}
