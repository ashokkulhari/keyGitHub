package com.key.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.key.configuration.Auditable;



@Entity
@Table(name = "company")
public class Company extends Auditable<String> implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="company_id")
	private int companyId;
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="is_deleted")
	private int isDeleted;
	

	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	private Set<User> users;
		
	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	private Set<Group> groups;
	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	private Set<Role> roles;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Group> getGroups() {
		return groups;
	}
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
