package com.petbackend.test.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.petbackend.api.enums.BathTypeEnum;
import com.petbackend.api.enums.HairTypeEnum;
import com.petbackend.api.strategy.BathStrategy;
import com.petbackend.api.strategy.HairCareStrategy;
import com.petbackend.api.service.BasicService;
import com.petbackend.api.service.DryBathService;
import com.petbackend.api.service.LongHairCareService;
import com.petbackend.api.service.PerfumefulBathService;
import com.petbackend.api.service.PerfumelessBathService;
import com.petbackend.api.service.ShortHairCareService;
import com.petbackend.api.service.WaterBathService;

@RunWith(SpringRunner.class)
@SpringBootApplication
@EnableAutoConfiguration
@TestPropertySource(properties = {"mock.random-devices=false", "spring.application.name=BTest", "spring.jmx.default-domain=BTest"})
@EntityScan(basePackages ={"com.petbackend.api.model", "com.petbackend.api.enums"})
@EnableJpaRepositories(basePackages ={"com.petbackend.api.repository"})
@ComponentScan(basePackages ={"com.petbackend.api.service", "com.petbackend.api.factory"})
public class BasicServiceTest {
	
	private BasicService service;
	
	@Before
	public void setUp() {
		service = null;
	}
	
	@Test
	public void shouldInstantiateWaterBathService() throws ClassNotFoundException{
		service = BathStrategy.getInstance(BathTypeEnum.WATER);
		
		Assert.assertEquals(service.isClass(WaterBathService.class), true);		
	}
	
	@Test
	public void shouldInstantiateDryBathService() throws ClassNotFoundException{
		service = BathStrategy.getInstance(BathTypeEnum.DRY);
		
		Assert.assertEquals(service.isClass(DryBathService.class), true);		
	}
	
	@Test
	public void shouldInstantiatePerfumefulBathService() throws ClassNotFoundException{
		service = BathStrategy.getInstance(BathTypeEnum.PERFUMEFUL);
		
		Assert.assertEquals(service.isClass(PerfumefulBathService.class), true);		
	}
	
	@Test
	public void shouldInstantiatePerfumelessBathService() throws ClassNotFoundException{
		service = BathStrategy.getInstance(BathTypeEnum.PERFUMELESS);
		
		Assert.assertEquals(service.isClass(PerfumelessBathService.class), true);		
	}
	
	@Test
	public void shouldInstantiateLongHairService() throws ClassNotFoundException{
		service = HairCareStrategy.getInstance(HairTypeEnum.LONG);
		
		Assert.assertEquals(service.isClass(LongHairCareService.class), true);		
	}
	@Test
	public void shouldInstantiateShortHairService() throws ClassNotFoundException{
		service = HairCareStrategy.getInstance(HairTypeEnum.SHORT);
		
		Assert.assertEquals(service.isClass(ShortHairCareService.class), true);		
	}

}
