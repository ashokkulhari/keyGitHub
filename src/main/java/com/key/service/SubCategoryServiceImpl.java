package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.SubCategory;
import com.key.repository.SubCategoryRepository;
@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	public SubCategoryRepository subCategoryRepository;
	
	@Override
	public List<SubCategory> getAllSubCategory() {
		return subCategoryRepository.findAll();
	}

}
