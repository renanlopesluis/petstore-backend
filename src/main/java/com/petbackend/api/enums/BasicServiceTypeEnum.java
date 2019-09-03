package com.petbackend.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum BasicServiceTypeEnum {
	BATH(1), HAIR_CARE(2);

	private Integer code;

	private BasicServiceTypeEnum(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

	public static Optional<BasicServiceTypeEnum> getByCode(Integer code) {
		return Arrays.stream(values()).filter(x -> x.getCode().equals(code)).findFirst();
	}

}
