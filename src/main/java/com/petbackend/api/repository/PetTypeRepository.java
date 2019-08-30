package com.petbackend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petbackend.api.model.PetType;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long>{

}
