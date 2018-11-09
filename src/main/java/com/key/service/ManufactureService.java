package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Manufacture;
@Service
public interface ManufactureService {

	public List<Manufacture> getAllManufacture();
	public Manufacture findById(Integer id);
}
