package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.Unit;
@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer>{

}
