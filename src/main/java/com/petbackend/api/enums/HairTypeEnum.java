package com.petbackend.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum HairTypeEnum {
	SHORT(1, "Short hair"), LONG(2, "Long hair");
	
	private Integer code;
	private String description;
	
	private HairTypeEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static Optional<HairTypeEnum> getByCode(Integer code) {
		return Arrays.stream(values()).filter(x -> x.getCode().equals(code)).findFirst();
	}
}
