package com.petbackend.api.strategy;

import org.springframework.stereotype.Component;

import com.petbackend.api.enums.HairTypeEnum;
import com.petbackend.api.service.BasicService;
import com.petbackend.api.service.LongHairCareService;
import com.petbackend.api.service.ShortHairCareService;

@Component
public class HairCareStrategy {
	
	public static BasicService getInstance(HairTypeEnum hairType) throws ClassNotFoundException{
		switch(hairType) {
			case LONG: return new LongHairCareService();
			case SHORT: return new ShortHairCareService();
			default : throw new ClassNotFoundException();
		}
	}

}
