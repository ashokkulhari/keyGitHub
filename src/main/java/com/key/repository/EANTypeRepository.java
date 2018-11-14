package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.EANType;

@Repository
public interface EANTypeRepository extends JpaRepository<EANType, Integer>{

}
