package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Color;
@Service
public interface ColorService {

	public List<Color> getAllColor();
	
}
