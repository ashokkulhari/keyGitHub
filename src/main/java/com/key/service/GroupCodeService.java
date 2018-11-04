package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.GroupCode;
@Service
public interface GroupCodeService {

	public List<GroupCode> getAllGroupCode();
	
}
