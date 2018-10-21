package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.Set;


/**
 * The persistent class for the manufacture database table.
 * 
 */
@Entity
public class Manufacture extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="manufacture_id")
	private Integer manufactureId;
	
	@Column(name="manufacture_code")
	private String manufactureCode;
	
	@Column(name="is_active")
	private Boolean isActive;
	@Column(name="manufacture_name")
	private String manufactureName;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	//bi-directional many-to-one association to ProductMaster
	@OneToMany(mappedBy="manufacture", fetch=FetchType.EAGER)
	private Set<ProductMaster> productMasters;
	public Integer getManufactureId() {
		return manufactureId;
	}
	public void setManufactureId(Integer manufactureId) {
		this.manufactureId = manufactureId;
	}
	public String getManufactureCode() {
		return manufactureCode;
	}
	public void setManufactureCode(String manufactureCode) {
		this.manufactureCode = manufactureCode;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getManufactureName() {
		return manufactureName;
	}
	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
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