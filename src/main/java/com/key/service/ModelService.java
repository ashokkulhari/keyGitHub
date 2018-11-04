package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Model;
@Service
public interface ModelService {

	public List<Model> getAllModel();
}
