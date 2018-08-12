package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.key.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
	Company findByCompanyName(String companyName);
}
