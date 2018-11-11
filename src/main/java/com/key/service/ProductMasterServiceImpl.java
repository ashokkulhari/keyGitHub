package com.key.service;

import java.util.List;

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

	@Override
	public ProductMaster saveProductMaster(ProductMaster productMaster) {
		return productMasterRepository.save(productMaster);
	}

	@Override
	public List<ProductMaster> findByItemCode(String itemCode) {
		return productMasterRepository.findByItemCode(itemCode);
	}

	@Override
	public List<ProductMaster> findByItemName(String itemName) {
		return productMasterRepository.findByItemName(itemName);
	}

	@Override
	public List<ProductMaster> findByItemNameAndItemCode(String itemName, String itemCode) {
		return productMasterRepository.findByItemNameAndItemCode(itemName, itemCode);
	}

	@Override
	public List<ProductMaster> findByGroupCode(Integer group_code_id) {
		return productMasterRepository.findByGroupCode(group_code_id);
	}
}
