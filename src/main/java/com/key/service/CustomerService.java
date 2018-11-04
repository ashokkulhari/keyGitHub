package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Customer;
@Service
public interface CustomerService {

	public List<Customer> getAllCustomer();
	
}
