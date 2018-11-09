/**
 * 
 */
package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.Company;
import com.key.repository.CompanyRepository;

/**
 * @author Ashok
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	
	@Autowired
	public CompanyRepository companyRepository;
	
	@Override
	public List<Company> getAllCompany() {
		return companyRepository.findAll();
	}

	@Override
	public Company findById(Integer id) {
		return companyRepository.getOne(id);
	}

}
