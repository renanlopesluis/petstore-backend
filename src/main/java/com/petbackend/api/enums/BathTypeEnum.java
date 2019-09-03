package com.petbackend.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum BathTypeEnum {

	DRY(1, "Dry bath"), WATER(2, "Water bath"), PERFUMEFUL(3, "Perfumeful bath"), PERFUMELESS(4, "Perfumeless bath");

	private Integer code;
	private String description;

	private BathTypeEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return this.code;
	}
	
	public String getDescription() {
		return this.description;
	}

	public static Optional<BathTypeEnum> getByCode(Integer code) {
		return Arrays.stream(values()).filter(x -> x.getCode().equals(code)).findFirst();
	}

}
