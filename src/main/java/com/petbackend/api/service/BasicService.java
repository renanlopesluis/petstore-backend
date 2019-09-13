package com.petbackend.api.service;

import com.petbackend.api.model.Pet;

public interface BasicService {
	
	void execute (Pet pet);
	
	boolean isClass(Class<?> classIdentity);

}
