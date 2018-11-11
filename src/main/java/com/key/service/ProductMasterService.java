package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.ProductMaster;
@Service
public interface ProductMasterService {

	
	ProductMaster getProductMasterById(int id);
	
	ProductMaster saveProductMaster(ProductMaster productMaster);
	
	List<ProductMaster> findByItemCode(String itemCode);
	List<ProductMaster> findByItemName(String itemName);
	List<ProductMaster> findByItemNameAndItemCode(String itemName,String itemCode);
	List<ProductMaster> findByGroupCode(Integer group_code_id);
}
