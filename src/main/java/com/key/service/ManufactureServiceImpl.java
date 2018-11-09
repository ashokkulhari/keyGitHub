package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.Manufacture;
import com.key.repository.ManufactureRepository;
@Service
public class ManufactureServiceImpl implements ManufactureService{

	@Autowired
	public ManufactureRepository manufactureRepository;
	
	@Override
	public List<Manufacture> getAllManufacture() {
		return manufactureRepository.findAll();
	}

	@Override
	public Manufacture findById(Integer id) {
		return manufactureRepository.getOne(id);
	}

}
