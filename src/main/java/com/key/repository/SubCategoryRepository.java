package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.SubCategory;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer>{

}
