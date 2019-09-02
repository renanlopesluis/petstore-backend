package com.petbackend.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.petbackend.api.model.PetType;
import com.petbackend.api.repository.PetTypeRepository;
import com.petbackend.test.dataprovider.PetTypeDataProvider;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackageClasses = PetTypeRepository.class)
@EntityScan(basePackageClasses = PetType.class)
public class petTypeServiceTest {
	
	@Autowired
	PetTypeDataProvider dataProvider;

	@Test
	public void shouldSaveAPetType() {
	PetType petType = dataProvider.build();
		Assert.assertNotNull(petType);
		Assert.assertNotNull(petType.getId());
	}
}
