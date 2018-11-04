package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.GroupCode;
import com.key.repository.GroupCodeRepository;
@Service
public class GroupCodeServiceImpl implements GroupCodeService{

	@Autowired
	public GroupCodeRepository groupCodeRepository;
	
	@Override
	public List<GroupCode> getAllGroupCode() {
		return groupCodeRepository.findAll();
	}

}
