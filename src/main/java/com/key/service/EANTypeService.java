package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.EANType;
@Service
public interface EANTypeService {

	List<EANType> getEANType();

}
