package com.key.model;

import java.util.Set;


public class ProductMasterModel {

	private Integer productId;
	private Double dangerLevel;
	private Boolean isDeleted;
	private Double itemAvgCost;
	private String itemBarCode;
	private String itemCode;
	private Double itemCost;//cost
	private Double itemDiscount;
	private String itemLocationName;
	private Double itemMinSellPrice;
	private String itemName;
	private Double itemSellPrice;
	private Double itemShopCost;
	private Double itemTenderPrice;
	private Double itemWSalePrice;
	private Integer madeinId;
	private Double maxLevel;
	private Double minLevel;
	private Double reoRderLevel;
	
	private Integer eanCodeType;
	private Boolean isAssetItem;
	private Boolean isCancelled;
	private Boolean isWorkItem;
	private Boolean isIncludePromotion;
	private Boolean isFocAllowed;
	private Double priceCode;
	private Double actPurCost;
	
	private Integer ItemCategorySno;
	private Boolean isActive;
	private Integer companyId;
	private Set<Integer> invoiceDetails;
	private Integer colorId;
	private Integer groupCodeId;
	private Integer locationId;
	private Integer manufactureId;
	private Integer modelId;
	private Integer categoryId;
	private Integer subCategoryId;
	private Integer unitId;
	private Integer salesUnitId;
	private Integer purchaseUnitId;
	private Integer vendorId;
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Set<Integer> getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(Set<Integer> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	public Integer getColorId() {
		return colorId;
	}
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}
	public Integer getGroupCodeId() {
		return groupCodeId;
	}
	public void setGroupCodeId(Integer groupCodeId) {
		this.groupCodeId = groupCodeId;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Integer getManufactureId() {
		return manufactureId;
	}
	public void setManufactureId(Integer manufactureId) {
		this.manufactureId = manufactureId;
	}
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getSalesUnitId() {
		return salesUnitId;
	}
	public void setSalesUnitId(Integer salesUnitId) {
		this.salesUnitId = salesUnitId;
	}
	public Integer getPurchaseUnitId() {
		return purchaseUnitId;
	}
	public void setPurchaseUnitId(Integer purchaseUnitId) {
		this.purchaseUnitId = purchaseUnitId;
	}
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	
	
	
}
