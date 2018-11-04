package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.InvoiceDetail;
@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer>{

}
