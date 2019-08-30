package com.petbackend.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petbackend.api.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

	List<Pet> findByAge(Integer age);
}
