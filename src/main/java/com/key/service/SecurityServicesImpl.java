package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.key.model.AclConfig;
import com.key.repository.AclConfigRepository;

@Service
public class SecurityServicesImpl implements SecurityServices {

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
//	@Autowired
//	SessionRegistry sessionRegistry ;
	@Autowired
	AclConfigRepository aclConfigRepository; 
	
	@Override
	public List<AclConfig> findAll() {
		return aclConfigRepository.findAll();
	}
	

	
}
