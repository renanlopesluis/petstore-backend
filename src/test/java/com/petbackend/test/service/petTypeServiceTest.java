package com.petbackend.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.petbackend.api.builder.PetTypeBuilder;
import com.petbackend.api.model.PetType;
import com.petbackend.api.service.PetTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class petTypeServiceTest {
	
	@Autowired
	@Qualifier("petTypeServiceImpl")
	PetTypeService petTypeService;

	@Test
	public void shouldSaveAPetType() {
		PetType type = petTypeService.save(PetTypeBuilder.build(null, "Dog"));
		Assert.assertNotNull(type.getId());
	}
}
