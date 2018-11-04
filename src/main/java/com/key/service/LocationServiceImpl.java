package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.Location;
import com.key.repository.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	public LocationRepository locationRepository;
	
	@Override
	public List<Location> getAllLocation() {
		return locationRepository.findAll();
	}

}
