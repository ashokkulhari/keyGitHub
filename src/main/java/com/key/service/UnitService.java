package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Unit;
@Service
public interface UnitService {
	public List<Unit> getAllUnit();
	public Unit findById(Integer id);
}
