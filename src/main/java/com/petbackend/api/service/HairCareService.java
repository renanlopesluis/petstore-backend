package com.petbackend.api.service;

import org.springframework.stereotype.Service;

@Service
public abstract class HairCareService implements BasicService{
	
	public boolean isClass(Class<?> classIdentity) {
		return this.getClass().equals(classIdentity);
	}
}
