package com.petbackend.api.module;

import com.google.inject.AbstractModule;
import com.petbackend.api.service.PetService;
import com.petbackend.api.service.PetServiceImpl;

public class PetServiceModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(PetService.class).to(PetServiceImpl.class);
	}
	
}
