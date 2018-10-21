package com.key.service;

import org.springframework.stereotype.Service;

import com.key.model.ProductMaster;
@Service
public interface ProductMasterService {

	
	ProductMaster getProductMasterById(int id);
}
