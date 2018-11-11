package com.key.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.key.configuration.Auditable;





@Entity
@Table(name = "company")
public class Company extends Auditable<String> implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="company_id")
	private Integer companyId;
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;
	
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Category> categories;
	@OneToMany(mappedBy="company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Color> colors;
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Customer> customers;
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<GroupCode> groupCodes;
	@JsonIgnore
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Invoice> invoices;
	@JsonIgnore
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<InvoiceDetail> invoiceDetails;
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Location> locations;
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Manufacture> manufactures;
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Model> models;
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ProductMaster> productMasters;
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Unit> units;
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Vendor> vendors;
	
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<User> users;
		
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Group> groups;
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Role> roles;
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public Set<Color> getColors() {
		return colors;
	}
	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	public Set<GroupCode> getGroupCodes() {
		return groupCodes;
	}
	public void setGroupCodes(Set<GroupCode> groupCodes) {
		this.groupCodes = groupCodes;
	}
	public Set<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}
	public Set<InvoiceDetail> getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	public Set<Location> getLocations() {
		return locations;
	}
	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
	public Set<Manufacture> getManufactures() {
		return manufactures;
	}
	public void setManufactures(Set<Manufacture> manufactures) {
		this.manufactures = manufactures;
	}
	public Set<Model> getModels() {
		return models;
	}
	public void setModels(Set<Model> models) {
		this.models = models;
	}
	public Set<ProductMaster> getProductMasters() {
		return productMasters;
	}
	public void setProductMasters(Set<ProductMaster> productMasters) {
		this.productMasters = productMasters;
	}
	public Set<Unit> getUnits() {
		return units;
	}
	public void setUnits(Set<Unit> units) {
		this.units = units;
	}
	public Set<Vendor> getVendors() {
		return vendors;
	}
	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Group> getGroups() {
		return groups;
	}
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
