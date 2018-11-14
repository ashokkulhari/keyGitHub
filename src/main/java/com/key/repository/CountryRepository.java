package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.key.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
