package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.InvoiceDetail;
import com.key.repository.InvoiceDetailRepository;
@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

	@Autowired
	public InvoiceDetailRepository invoiceDetailRepository;
	

	@Override
	public List<InvoiceDetail> getAllInvoiceDetail() {
		return invoiceDetailRepository.findAll();
	}

}
