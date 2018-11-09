package com.key.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.key.model.Invoice;
@Service
public interface InvoiceService {

	public List<Invoice> getAllInvoice();
	public Invoice findById(Integer id);
}
