package com.key.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.Auditable;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@Table(name = "permission")
public class Permission extends Auditable<String> implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="permission_id")
	private int permissionId;
	
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