package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Category;

@Service
public interface CategoryService {

	public List<Category> getAllCategory();
}
