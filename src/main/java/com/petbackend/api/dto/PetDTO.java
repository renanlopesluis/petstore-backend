package com.petbackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class PetDTO {

	private Long id;
	private String name;
	private String type;
	private Integer age;	
	
}
