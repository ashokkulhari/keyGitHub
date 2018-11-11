package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.Set;


@Entity
public class Category extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="category_id")
	private Integer categoryId;
	@Column(name="category_name")
	private String categoryName;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	@Column(name="is_active")
	private Boolean isActive;
	@Column(name="category_sno")
	private Integer categorySno;
	

	//bi-directional many-to-one association to SubCategory
	@JsonIgnore
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SubCategory> subCategories;


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public Integer getCategorySno() {
		return categorySno;
	}


	public void setCategorySno(Integer categorySno) {
		this.categorySno = categorySno;
	}


	public Set<SubCategory> getSubCategories() {
		return subCategories;
	}


	public void setSubCategories(Set<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}



}