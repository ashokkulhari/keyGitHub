package com.key.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

@Entity
@Table(name="eantype")
public class EANType extends Auditable<Integer> implements Serializable{

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="eantype_id")
	private Integer eanTypeId;
	@Column(name="eantype_code")
	private String eanTypeCode;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	@Column(name="is_active")
	private Boolean isActive;
	public Integer getEanTypeId() {
		return eanTypeId;
	}
	public void setEanTypeId(Integer eanTypeId) {
		this.eanTypeId = eanTypeId;
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getEanTypeCode() {
		return eanTypeCode;
	}
	public void setEanTypeCode(String eanTypeCode) {
		this.eanTypeCode = eanTypeCode;
	}
	
	
}
