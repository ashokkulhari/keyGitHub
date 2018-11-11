package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.Set;


/**
 * The persistent class for the units database table.
 * 
 */
@Entity
@Table(name="units")
public class Unit extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="unit_id")
	private Integer unitId;
	@Column(name="is_active")
	private Boolean isActive;
	@Column(name="unit_name")
	private String unitName;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	//bi-directional many-to-one association to InvoiceDetail
	@JsonIgnore
	@OneToMany(mappedBy="unit",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<InvoiceDetail> invoiceDetails;
	//bi-directional many-to-one association to ProductMaster
	@JsonIgnore
	@OneToMany(mappedBy="unit",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ProductMaster> productMasters;
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Set<InvoiceDetail> getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	public Set<ProductMaster> getProductMasters() {
		return productMasters;
	}
	public void setProductMasters(Set<ProductMaster> productMasters) {
		this.productMasters = productMasters;
	}
	
	
	
}