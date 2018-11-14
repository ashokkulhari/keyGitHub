package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.Country;
import com.key.repository.CountryRepository;
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<Country> getCountry() {
		return countryRepository.findAll();
	}
}
