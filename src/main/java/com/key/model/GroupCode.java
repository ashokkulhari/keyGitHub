package com.key.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.Set;


/**
 * The persistent class for the group_code database table.
 * 
 */
@Entity
@Table(name="group_code")
public class GroupCode extends Auditable<Integer> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="group_code_id")
	private Integer groupCodeId;
	@Column(name="group_code_name")
	private String groupCodeName;
	@Column(name="is_active")
	private Boolean isActive;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	//bi-directional many-to-one association to ProductMaster
	@OneToMany(mappedBy="groupCode", fetch=FetchType.EAGER)
	private Set<ProductMaster> productMasters;

	public Integer getGroupCodeId() {
		return groupCodeId;
	}

	public void setGroupCodeId(Integer groupCodeId) {
		this.groupCodeId = groupCodeId;
	}

	public String getGroupCodeName() {
		return groupCodeName;
	}

	public void setGroupCodeName(String groupCodeName) {
		this.groupCodeName = groupCodeName;
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

	public Set<ProductMaster> getProductMasters() {
		return productMasters;
	}

	public void setProductMasters(Set<ProductMaster> productMasters) {
		this.productMasters = productMasters;
	}

	
}