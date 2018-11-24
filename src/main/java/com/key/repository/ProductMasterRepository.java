package com.key.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.key.model.ProductMaster;


public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer>{

	@Query("SELECT e FROM ProductMaster e WHERE e.isActive=1 and e.itemCode =:itemCode order by itemName ASC ")
	List<ProductMaster> findByItemCode(String itemCode);
	
	@Query("SELECT e FROM ProductMaster e WHERE e.isActive=1 and e.itemName =:itemName order by itemName ASC ")
	List<ProductMaster> findByItemName(String itemName);
	
//	@Query("SELECT e FROM ProductMaster e WHERE  e.itemCode =:itemCode order by itemName ASC ")
//	List<ProductMaster> findByItemCode(@Param("itemCode") String itemCode);
	
	@Query("SELECT e FROM ProductMaster e WHERE e.isActive=1 and e.itemName like %:itemName%  order by itemName ASC ")
	List<ProductMaster> matchByItemName(@Param("itemName") String itemName);
	
	@Query("SELECT e FROM ProductMaster e WHERE e.isActive=1 and e.groupCode.groupCodeId =:groupCodeId order by itemName ASC ")
	List<ProductMaster> findByGroupCode(@Param("groupCodeId") Integer groupCodeId);
	
	@Query("SELECT e FROM ProductMaster e WHERE e.isActive=1 and e.category.categoryId =:categoryId order by itemName ASC ")
	List<ProductMaster> findByCategory(@Param("categoryId") Integer categoryId);
	
	@Query("SELECT e FROM ProductMaster e WHERE e.isActive=1 and e.manufacture.manufactureId =:manufactureId order by itemName ASC ")
	List<ProductMaster> findByManufacture(@Param("manufactureId") Integer manufactureId);
	
	
	@Query("SELECT e FROM ProductMaster e WHERE e.isActive=1 and e.vendor.vendorId =:vendorId order by itemName ASC ")
	List<ProductMaster> findByVendor(@Param("vendorId") Integer vendorId);
}
