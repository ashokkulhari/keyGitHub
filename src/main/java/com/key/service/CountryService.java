package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Country;
@Service
public interface CountryService {

	 List<Country> getCountry() ;

}
