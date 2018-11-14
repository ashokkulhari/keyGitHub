package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.ProductMaster;
@Service
public interface ProductMasterService {

	
	ProductMaster getProductMasterById(int id);
	
	List<ProductMaster> getAllProductMaster();
	
	ProductMaster saveProductMaster(ProductMaster productMaster);
	
	List<ProductMaster> findByItemCode(String itemCode);
	List<ProductMaster> findByItemName(String itemName);
	List<ProductMaster> matchByItemName(String itemName);
	List<ProductMaster> findByGroupCode(Integer group_code_id);
	
	List<ProductMaster> findByCategory(Integer categoryId);
	
	List<ProductMaster> findByManufacture(Integer manufactureId);
	
	List<ProductMaster> findByVendor(Integer vendorId);
}
