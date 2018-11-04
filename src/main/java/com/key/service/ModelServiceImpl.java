package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.Model;
import com.key.repository.ModelRepository;
@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	public ModelRepository modelRepository;
	
	@Override
	public List<Model> getAllModel() {
		return modelRepository.findAll();
	}

}
