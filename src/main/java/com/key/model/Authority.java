package com.key.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "authority")
public class Authority implements Serializable {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="authority_id")
	private int authorityId;
	@Column(name="authority_name")
	private String authorityName;
	@Column(name = "audit_insert_date")
	private Timestamp auditInsertDate;

	@Column(name = "audit_update_date")
	private Timestamp auditUpdatetDate;

	@OneToMany(mappedBy="authority", fetch=FetchType.EAGER)
	private Set<AclConfig> aclConfigs;
	@OneToMany(mappedBy="authority", fetch=FetchType.EAGER)
	private Set<PermissionSet> permissionSet;
	public int getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
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
	public Set<AclConfig> getAclConfigs() {
		return aclConfigs;
	}
	public void setAclConfigs(Set<AclConfig> aclConfigs) {
		this.aclConfigs = aclConfigs;
	}
	public Set<PermissionSet> getPermissionSet() {
		return permissionSet;
	}
	public void setPermissionSet(Set<PermissionSet> permissionSet) {
		this.permissionSet = permissionSet;
	}
	
	

	
}
