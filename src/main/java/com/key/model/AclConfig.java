package com.key.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acl_config")
public class AclConfig {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="acl_id")	
	private int aclId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="page")
	private String page;
	
	@Column(name="path")
	private String path;
	
	@Column(name="values")
	private String values;
	
	@Column(name = "audit_insert_date")
	private Timestamp auditInsertDate;

	@Column(name = "audit_update_date")
	private Timestamp auditUpdatetDate;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public Timestamp getAuditInsertDate() {
		return auditInsertDate;
	}

	public void setAuditInsertDate(Timestamp auditInsertDate) {
		this.auditInsertDate = auditInsertDate;
	}

	public Timestamp getAuditUpdatetDate() {
		return auditUpdatetDate;
	}

	public void setAuditUpdatetDate(Timestamp auditUpdatetDate) {
		this.auditUpdatetDate = auditUpdatetDate;
	}

	public int getAclId() {
		return aclId;
	}

	public void setAclId(int aclId) {
		this.aclId = aclId;
	}
	
}
