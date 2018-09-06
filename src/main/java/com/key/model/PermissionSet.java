package com.key.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "permission_set")
public class PermissionSet implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="permission_set_id")
	private int permissionSetId;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="authority_id")
	private Authority authority;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="permission_id")
	private Permission  permission;
	
	@JsonIgnore
	@ManyToMany(mappedBy="permissionSets", fetch=FetchType.EAGER)
	private Set<Role> roles;

	public int getPermissionSetId() {
		return permissionSetId;
	}

	public void setPermissionSetId(int permissionSetId) {
		this.permissionSetId = permissionSetId;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	  
}
