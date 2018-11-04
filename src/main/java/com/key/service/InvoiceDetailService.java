package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.InvoiceDetail;
@Service
public interface InvoiceDetailService {

	public List<InvoiceDetail> getAllInvoiceDetail();
	
}
