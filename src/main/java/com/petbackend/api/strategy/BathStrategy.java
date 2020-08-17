package com.petbackend.api.strategy;

import org.springframework.stereotype.Component;

import com.petbackend.api.enums.BathTypeEnum;
import com.petbackend.api.service.BasicService;
import com.petbackend.api.service.DryBathService;
import com.petbackend.api.service.PerfumefulBathService;
import com.petbackend.api.service.PerfumelessBathService;
import com.petbackend.api.service.WaterBathService;

@Component
public class BathStrategy {

	public static BasicService getInstance(BathTypeEnum bathType) throws ClassNotFoundException{
		switch(bathType) {
			case DRY: return new DryBathService();
			case WATER: return new WaterBathService();
			case PERFUMEFUL: return new PerfumefulBathService();
			case PERFUMELESS: return new PerfumelessBathService();
			default : throw new ClassNotFoundException();
		}
	}

}
