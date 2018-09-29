package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.AclConfig;

@Service
public interface SecurityServices {

	
	public List<AclConfig> findAll(); 
	
}
