package com.key.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@Table(name = "permission")
public class Permission implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="permission_id")
	private int permissionId;
	@Column(name = "audit_insert_date")
	private Timestamp auditInsertDate;

	@Column(name = "audit_update_date")
	private Timestamp auditUpdatetDate;
	@Column(name="permission_name")
	private String permissionName;
	
	@OneToMany(mappedBy="permission", fetch=FetchType.EAGER)
	private Set<PermissionSet> permissionSet;

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
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

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Set<PermissionSet> getPermissionSet() {
		return permissionSet;
	}

	public void setPermissionSet(Set<PermissionSet> permissionSet) {
		this.permissionSet = permissionSet;
	}

}