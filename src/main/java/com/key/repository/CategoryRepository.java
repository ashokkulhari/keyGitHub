package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findCategoryByCategorySno(Integer categorySno);
}
