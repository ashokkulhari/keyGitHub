package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.Set;


/**
 * The persistent class for the vendor database table.
 * 
 */
@Entity
public class Vendor extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="vendor_id")
	private Integer vendorId;
	@Column(name="is_active")
	private Boolean isActive;
	@Column(name="vendor_name")
	private String vendorName;
	
	
	@Column(name="vendor_address")
	private String vendorAddress;
	
	@Column(name="vendor_contact_number")
	private String vendorContactNumber;
	
	
	@Column(name="vendor_country_id")
	private Integer vendorCountryId;
	
	@Column(name="vendor_city_id")
	private Integer vendorCityId;
	
	@Column(name="vendor_state_id")
	private Integer vendorStateId;
	
	@Column(name="vendor_email")
	private String vendorEmail;
	
	@Column(name="vendor_website")
	private String vendorWebSite;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	//bi-directional many-to-one association to ProductMaster
	@OneToMany(mappedBy="vendor", fetch=FetchType.EAGER)
	private Set<ProductMaster> productMasters;

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorContactNumber() {
		return vendorContactNumber;
	}

	public void setVendorContactNumber(String vendorContactNumber) {
		this.vendorContactNumber = vendorContactNumber;
	}

	public Integer getVendorCountryId() {
		return vendorCountryId;
	}

	public void setVendorCountryId(Integer vendorCountryId) {
		this.vendorCountryId = vendorCountryId;
	}

	public Integer getVendorCityId() {
		return vendorCityId;
	}

	public void setVendorCityId(Integer vendorCityId) {
		this.vendorCityId = vendorCityId;
	}

	public Integer getVendorStateId() {
		return vendorStateId;
	}

	public void setVendorStateId(Integer vendorStateId) {
		this.vendorStateId = vendorStateId;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getVendorWebSite() {
		return vendorWebSite;
	}

	public void setVendorWebSite(String vendorWebSite) {
		this.vendorWebSite = vendorWebSite;
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