package com.key.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.Set;


@Entity
public class Invoice extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="invoice_id")
	private Integer invoiceId;
	@Column(name="address")
	private String address;
	@Column(name="attention")
	private String attention;
	
	@Column(name="cust_ref")
	private String custRef;
	@Column(name="invoice_no")
	private String invoiceNo;
	@Column(name="is_active")
	private Boolean isActive;
	@Column(name="lpo_date")
	private Timestamp lpoDate;
	@Column(name="lpo_number")
	private String lpoNumber;
	@Column(name="sr_no")
	private Integer srNo;
	@Column(name="tele_phone")
	private String telePhone;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	//bi-directional many-to-one association to InvoiceDetail
	@OneToMany(mappedBy="invoice", fetch=FetchType.EAGER)
	private Set<InvoiceDetail> invoiceDetails;
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getCustRef() {
		return custRef;
	}
	public void setCustRef(String custRef) {
		this.custRef = custRef;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Timestamp getLpoDate() {
		return lpoDate;
	}
	public void setLpoDate(Timestamp lpoDate) {
		this.lpoDate = lpoDate;
	}
	public String getLpoNumber() {
		return lpoNumber;
	}
	public void setLpoNumber(String lpoNumber) {
		this.lpoNumber = lpoNumber;
	}
	public Integer getSrNo() {
		return srNo;
	}
	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<InvoiceDetail> getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	
	
}