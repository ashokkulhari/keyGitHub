package com.key.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;



/**
 * The persistent class for the invoice_details database table.
 * 
 */
@Entity
@Table(name="invoice_details")
public class InvoiceDetail extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="invoice_line_id")
	private Integer invoiceLineId;
	@Column(name="date_of_expiry")
	private Timestamp dateOfExpiry;
	@Column(name="discontiued")
	private Integer discontiued;
	@Column(name="discount")
	private Double discount;
	@Column(name="discount_per")
	private Double discountPer;
	@Column(name="is_deleted")
	private Boolean isDeleted;
	@Column(name="landig_cost")
	private Double landigCost;
	@Column(name="qty")
	private Integer qty;
	@Column(name="sell_price")
	private Double sellPrice;
	@Column(name="total")
	private Double total;
	@Column(name="unit_price")
	private Double unitPrice;
	@Column(name="units_in_stock")
	private Integer unitsInStock;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	//bi-directional many-to-one association to Invoice
	@ManyToOne
	@JoinColumn(name="invoice_id")
	private Invoice invoice;
	//bi-directional many-to-one association to ProductMaster
	@ManyToOne
	@JoinColumn(name="item_id")
	private ProductMaster productMaster;
	//bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name="unit_id")
	private Unit unit;
	public Integer getInvoiceLineId() {
		return invoiceLineId;
	}
	public void setInvoiceLineId(Integer invoiceLineId) {
		this.invoiceLineId = invoiceLineId;
	}
	public Timestamp getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(Timestamp dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public Integer getDiscontiued() {
		return discontiued;
	}
	public void setDiscontiued(Integer discontiued) {
		this.discontiued = discontiued;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getDiscountPer() {
		return discountPer;
	}
	public void setDiscountPer(Double discountPer) {
		this.discountPer = discountPer;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Double getLandigCost() {
		return landigCost;
	}
	public void setLandigCost(Double landigCost) {
		this.landigCost = landigCost;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public ProductMaster getProductMaster() {
		return productMaster;
	}
	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	
}