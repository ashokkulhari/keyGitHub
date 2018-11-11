package com.key.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.model.Invoice;
import com.key.repository.InvoiceRepository;
@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	public InvoiceRepository invoiceRepository;
	
	@Override
	public List<Invoice> getAllInvoice() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice findById(Integer id) {
		return invoiceRepository.getOne(id);
	}

	@Override
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

}
