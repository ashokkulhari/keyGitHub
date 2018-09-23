package com.key.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.key.configuration.Auditable;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the k_role database table.
 * 
 */
@Entity
@Table(name="k_role")
public class Role extends Auditable<String> implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;
	//bi-directional many-to-many association to KGroup
		@ManyToMany(fetch=FetchType.EAGER)
		@JoinTable(
			name="group_role"
			, joinColumns={
				@JoinColumn(name="role_role_id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="group_group_id")
				}
			)
	private Set<Group> Groups;
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="per_set_role"
		, joinColumns={
			@JoinColumn(name="role_role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="per_set_per_set_id")
			}
		)
	private Set<PermissionSet> permissionSets;


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Set<Group> getGroups() {
		return Groups;
	}


	public void setGroups(Set<Group> groups) {
		Groups = groups;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Set<PermissionSet> getPermissionSets() {
		return permissionSets;
	}


	public void setPermissionSets(Set<PermissionSet> permissionSets) {
		this.permissionSets = permissionSets;
	}



}