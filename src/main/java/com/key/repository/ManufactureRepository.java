package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.Manufacture;
@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Integer>{

}
