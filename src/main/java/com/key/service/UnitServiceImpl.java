package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.Unit;
import com.key.repository.UnitRepository;
@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	public UnitRepository unitRepository;
	
	@Override
	public List<Unit> getAllUnit() {
		return unitRepository.findAll();
	}

	@Override
	public Unit findById(Integer id) {
		return unitRepository.getOne(id);
	}

}
