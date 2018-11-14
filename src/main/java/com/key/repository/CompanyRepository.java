package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	Company findByCompanyName(String companyName);
}
