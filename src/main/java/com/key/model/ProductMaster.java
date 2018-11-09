package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.key.configuration.Auditable;

import java.util.Set;


/**
 * The persistent class for the product_master database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="product_master")
public class ProductMaster extends Auditable<Integer> implements Serializable {
	
	/**
	 * 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private Integer itemId;
	@Column(name="danger_level",nullable = true)
	private Double dangerLevel;
	@Column(name="is_deleted",nullable = true)
	private Boolean isDeleted;
	@Column(name="item_avg_cost",nullable = true)
	private Double itemAvgCost;
	@Column(name="item_bar_code",nullable = true)
	private String itemBarCode;
	@Column(name="item_code",nullable = true)
	private String itemCode;
	@Column(name="item_cost",nullable = true)
	private Double itemCost;//cost
	@Column(name="item_discount",nullable = true)
	private Double itemDiscount;
	@Column(name="item_location_name",nullable = true)
	private String itemLocationName;
	@Column(name="item_min_sell_price")
	private Double itemMinSellPrice;
	@Column(name="item_name",nullable = true)
	private String itemName;
	@Column(name="item_sell_price",nullable = true)
	private Double itemSellPrice;
	@Column(name="item_shop_cost",nullable = true)
	private Double itemShopCost;
	@Column(name="item_tender_price",nullable = true)
	private Double itemTenderPrice;
	@Column(name="item_w_sale_price",nullable = true)
	private Double itemWSalePrice;
	@Column(name="madein_id",nullable = true)
	private Integer madeinId;
	@Column(name="max_level",nullable = true)
	private Double maxLevel;
	@Column(name="min_level",nullable = true)
	private Double minLevel;
	@Column(name="reo_rder_level",nullable = true)
	private Double reoRderLevel;
	
	@Column(name="ean_code_type",nullable = true)
	private Integer eanCodeType;
	@Column(name="is_asset_item",nullable = true)
	private Boolean isAssetItem;
	@Column(name="is_cancelled",nullable = true)
	private Boolean isCancelled;
	@Column(name="is_work_item",nullable = true)
	private Boolean isWorkItem;
	@Column(name="is_include_promotion",nullable = true)
	private Boolean isIncludePromotion;
	@Column(name="is_foc_allowed",nullable = true)
	private Boolean isFocAllowed;
	
	
	@Column(name="price_code",nullable = true)
	private Double priceCode;
	
	@Column(name="act_pur_cost",nullable = true)
	private Double actPurCost;
	
	@Column(name="item_category_sno",nullable = true)
	private Integer ItemCategorySno;
	// active
	@Column(name="is_active",nullable = true)
	private Boolean isActive;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	//bi-directional many-to-one association to InvoiceDetail
	@OneToMany(mappedBy="productMaster", fetch=FetchType.EAGER)
	private Set<InvoiceDetail> invoiceDetails;
	//bi-directional many-to-one association to Color
//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;
	//bi-directional many-to-one association to GroupCode
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="group_code_id")
	private GroupCode groupCode;
	//bi-directional many-to-one association to Location
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	//bi-directional many-to-one association to Manufacture
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="manufacture_id")
	private Manufacture manufacture;
	//bi-directional many-to-one association to Model
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	//bi-directional many-to-one association to SubCategory
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="sub_category_id")
	private SubCategory subCategory;
	//bi-directional many-to-one association to Unit
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="unit_id")
	private Unit unit;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="sale_unit_id")
	private Unit salesUnit;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="purchase_unit_id")
	private Unit purchaseUnit;
	//bi-directional many-to-one association to Vendor
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="vendor_id")
	private Vendor vendor;
	
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Double getDangerLevel() {
		return dangerLevel;
	}
	public void setDangerLevel(Double dangerLevel) {
		this.dangerLevel = dangerLevel;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Double getItemAvgCost() {
		return itemAvgCost;
	}
	public void setItemAvgCost(Double itemAvgCost) {
		this.itemAvgCost = itemAvgCost;
	}
	public String getItemBarCode() {
		return itemBarCode;
	}
	public void setItemBarCode(String itemBarCode) {
		this.itemBarCode = itemBarCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Double getItemCost() {
		return itemCost;
	}
	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}
	public Double getItemDiscount() {
		return itemDiscount;
	}
	public void setItemDiscount(Double itemDiscount) {
		this.itemDiscount = itemDiscount;
	}
	public String getItemLocationName() {
		return itemLocationName;
	}
	public void setItemLocationName(String itemLocationName) {
		this.itemLocationName = itemLocationName;
	}
	public Double getItemMinSellPrice() {
		return itemMinSellPrice;
	}
	public void setItemMinSellPrice(Double itemMinSellPrice) {
		this.itemMinSellPrice = itemMinSellPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemSellPrice() {
		return itemSellPrice;
	}
	public void setItemSellPrice(Double itemSellPrice) {
		this.itemSellPrice = itemSellPrice;
	}
	public Double getItemShopCost() {
		return itemShopCost;
	}
	public void setItemShopCost(Double itemShopCost) {
		this.itemShopCost = itemShopCost;
	}
	public Double getItemTenderPrice() {
		return itemTenderPrice;
	}
	public void setItemTenderPrice(Double itemTenderPrice) {
		this.itemTenderPrice = itemTenderPrice;
	}
	public Double getItemWSalePrice() {
		return itemWSalePrice;
	}
	public void setItemWSalePrice(Double itemWSalePrice) {
		this.itemWSalePrice = itemWSalePrice;
	}
	public Integer getMadeinId() {
		return madeinId;
	}
	public void setMadeinId(Integer madeinId) {
		this.madeinId = madeinId;
	}
	public Double getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(Double maxLevel) {
		this.maxLevel = maxLevel;
	}
	public Double getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(Double minLevel) {
		this.minLevel = minLevel;
	}
	public Double getReoRderLevel() {
		return reoRderLevel;
	}
	public void setReoRderLevel(Double reoRderLevel) {
		this.reoRderLevel = reoRderLevel;
	}
	public Integer getEanCodeType() {
		return eanCodeType;
	}
	public void setEanCodeType(Integer eanCodeType) {
		this.eanCodeType = eanCodeType;
	}
	public Boolean getIsAssetItem() {
		return isAssetItem;
	}
	public void setIsAssetItem(Boolean isAssetItem) {
		this.isAssetItem = isAssetItem;
	}
	public Boolean getIsCancelled() {
		return isCancelled;
	}
	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	public Boolean getIsWorkItem() {
		return isWorkItem;
	}
	public void setIsWorkItem(Boolean isWorkItem) {
		this.isWorkItem = isWorkItem;
	}
	public Boolean getIsIncludePromotion() {
		return isIncludePromotion;
	}
	public void setIsIncludePromotion(Boolean isIncludePromotion) {
		this.isIncludePromotion = isIncludePromotion;
	}
	public Boolean getIsFocAllowed() {
		return isFocAllowed;
	}
	public void setIsFocAllowed(Boolean isFocAllowed) {
		this.isFocAllowed = isFocAllowed;
	}
	public Double getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(Double priceCode) {
		this.priceCode = priceCode;
	}
	public Double getActPurCost() {
		return actPurCost;
	}
	public void setActPurCost(Double actPurCost) {
		this.actPurCost = actPurCost;
	}
	public Integer getItemCategorySno() {
		return ItemCategorySno;
	}
	public void setItemCategorySno(Integer itemCategorySno) {
		ItemCategorySno = itemCategorySno;
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
	public Set<InvoiceDetail> getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public GroupCode getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(GroupCode groupCode) {
		this.groupCode = groupCode;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Manufacture getManufacture() {
		return manufacture;
	}
	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public Unit getSalesUnit() {
		return salesUnit;
	}
	public void setSalesUnit(Unit salesUnit) {
		this.salesUnit = salesUnit;
	}
	public Unit getPurchaseUnit() {
		return purchaseUnit;
	}
	public void setPurchaseUnit(Unit purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	

}