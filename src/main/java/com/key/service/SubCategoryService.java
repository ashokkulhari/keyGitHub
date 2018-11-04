package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.SubCategory;
@Service
public interface SubCategoryService {
	public List<SubCategory> getAllSubCategory();
}
