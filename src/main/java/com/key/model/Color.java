package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.key.configuration.Auditable;

import java.util.Set;


/**
 * The persistent class for the color database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Color extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="color_id")
	private Integer colorId;
	@Column(name="color_name")
	private String colorName;
	@Column(name="is_active")
	private Boolean isActive;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	//bi-directional many-to-one association to ProductMaster
//	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="color",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ProductMaster> productMasters;
	public Integer getColorId() {
		return colorId;
	}
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Set<ProductMaster> getProductMasters() {
		return productMasters;
	}
	public void setProductMasters(Set<ProductMaster> productMasters) {
		this.productMasters = productMasters;
	}
	
	
}