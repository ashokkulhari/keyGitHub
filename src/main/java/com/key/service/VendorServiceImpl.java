package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.Vendor;
import com.key.repository.VendorRepository;
@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	public VendorRepository vendorRepository;
	
	@Override
	public List<Vendor> getAllVendor() {
		return vendorRepository.findAll();
	}

	@Override
	public Vendor findById(Integer id) {
		return vendorRepository.getOne(id);
	}

}
