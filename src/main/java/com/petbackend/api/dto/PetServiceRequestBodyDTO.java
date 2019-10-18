package com.petbackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PetServiceRequestBodyDTO {
	private Long petId;
	private Integer serviceCode;
}
