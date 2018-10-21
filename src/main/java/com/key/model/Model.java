package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.Set;


/**
 * The persistent class for the model database table.
 * 
 */
@Entity
public class Model extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="model_id")
	private Integer modelId;
	@Column(name="is_active")
	private Boolean isActive;
	@Column(name="model_name")
	private String modelName;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	//bi-directional many-to-one association to ProductMaster
	@OneToMany(mappedBy="model", fetch=FetchType.EAGER)
	private Set<ProductMaster> productMasters;
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
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