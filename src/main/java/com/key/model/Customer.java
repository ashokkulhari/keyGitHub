package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.Set;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
public class Customer extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private Integer customerId;
	@Column(name="address")
	private String address;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	@Column(name="contact_name")
	private String contactName;
	@Column(name="credit_limit")
	private Integer creditLimit;
	@Column(name="credit_period")
	private Integer creditPeriod;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="discount")
	private Integer discount;
	@Column(name="email")
	private String email;
	@Column(name="fax")
	private String fax;
	@Column(name="include_credit_limit")
	private Integer includeCreditLimit;
	@Column(name="internet")
	private String internet;
	@Column(name="is_deleted")
	private Boolean isDeleted;
	@Column(name="mobile")
	private String mobile;
	@Column(name="phone")
	private String phone;
	@Column(name="remarks")
	private String remarks;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	//bi-directional many-to-one association to Invoice
	@JsonIgnore
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Invoice> invoices;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Integer getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Integer getCreditPeriod() {
		return creditPeriod;
	}
	public void setCreditPeriod(Integer creditPeriod) {
		this.creditPeriod = creditPeriod;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Integer getIncludeCreditLimit() {
		return includeCreditLimit;
	}
	public void setIncludeCreditLimit(Integer includeCreditLimit) {
		this.includeCreditLimit = includeCreditLimit;
	}
	public String getInternet() {
		return internet;
	}
	public void setInternet(String internet) {
		this.internet = internet;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	
	
}