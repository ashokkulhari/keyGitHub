package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.Set;


/**
 * The persistent class for the sub_category database table.
 * 
 */
@Entity
@Table(name="sub_category")
public class SubCategory extends Auditable<Integer> implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_category_id")
	private Integer subCategoryId;
	@Column(name="is_active")
	private Boolean isActive;
	@Column(name="sub_category_name")
	private String subCategoryName;
	//bi-directional many-to-one association to ProductMaster
	@OneToMany(mappedBy="subCategory", fetch=FetchType.EAGER)
	private Set<ProductMaster> productMasters;
	//bi-directional many-to-one association to Category
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	public Integer getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public Set<ProductMaster> getProductMasters() {
		return productMasters;
	}
	public void setProductMasters(Set<ProductMaster> productMasters) {
		this.productMasters = productMasters;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}