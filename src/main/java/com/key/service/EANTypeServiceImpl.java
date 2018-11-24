package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.EANType;
import com.key.repository.EANTypeRepository;
@Service
public class EANTypeServiceImpl implements EANTypeService {

	@Autowired
	private EANTypeRepository eanTypeRepository;
	
	@Override
	public List<EANType> getEANType() {
		return eanTypeRepository.findAll();
	}

	@Override
	public EANType findById(Integer id) {
		return eanTypeRepository.getOne(id);
	}

}
