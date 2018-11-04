package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer>{

}
