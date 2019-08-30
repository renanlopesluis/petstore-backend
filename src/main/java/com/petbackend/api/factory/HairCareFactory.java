package com.petbackend.api.factory;

import com.petbackend.api.enums.HairTypeEnum;
import com.petbackend.api.service.LongHairCareService;
import com.petbackend.api.service.Service;
import com.petbackend.api.service.ShortHairCareService;

public class HairCareFactory {
	
	public static Service getInstance(HairTypeEnum hairType) throws ClassNotFoundException{
		switch(hairType) {
			case LONG: return new LongHairCareService();
			case SHORT: return new ShortHairCareService();
			default : throw new ClassNotFoundException();
		}
	}

}
