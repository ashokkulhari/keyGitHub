package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Company;

@Service
public interface CompanyService {

	
	public List<Company> getAllCompany();
	public Company findById(Integer id);
	
}
