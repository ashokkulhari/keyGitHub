package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Vendor;
@Service
public interface VendorService {

	public List<Vendor> getAllVendor();
	public Vendor findById(Integer id);
}
