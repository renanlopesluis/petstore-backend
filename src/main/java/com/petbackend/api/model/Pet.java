package com.petbackend.api.model;

import com.petbackend.api.model.PetType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Pet {
	
	private Integer id;
	private String name;
	private PetType type;
	private Integer age;

}
