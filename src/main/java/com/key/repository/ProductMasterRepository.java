package com.key.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.key.model.ProductMaster;


public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer>{

	
	List<ProductMaster> findByItemCode(String itemCode);
	List<ProductMaster> findByItemName(String itemName);
	
	@Query("SELECT e FROM ProductMaster e WHERE e.itemName =:itemName and e.itemCode =:itemCode order by itemName ASC ")
	List<ProductMaster> findByItemNameAndItemCode(@Param("itemName") String itemName,@Param("itemCode") String itemCode);
	
	@Query("SELECT e FROM ProductMaster e WHERE e.groupCode.groupCodeId =:group_code_id order by itemName ASC ")
	List<ProductMaster> findByGroupCode(@Param("group_code_id") Integer group_code_id);
}
