package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.Color;
import com.key.repository.ColorRepository;
@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	public ColorRepository colorRepository;
	
	@Override
	public List<Color> getAllColor() {
		return colorRepository.findAll();
	}

}
