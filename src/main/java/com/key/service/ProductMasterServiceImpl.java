package com.key.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.ProductMaster;
import com.key.repository.ProductMasterRepository;
@Service
public class ProductMasterServiceImpl implements ProductMasterService {

	
	@Autowired
	private ProductMasterRepository productMasterRepository;

	@Override
	public ProductMaster getProductMasterById(int id) {
		return productMasterRepository.getOne(id);
	}
}
