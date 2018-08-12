package com.key.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "k_group")
public class Group implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="group_id")
	private int groupId;
	@Column(name="group_name")
	private String groupName;
	@Column(name = "audit_insert_date")
	private Timestamp auditInsertDate;

	@Column(name = "audit_update_date")
	private Timestamp auditUpdatetDate;
	
	@JsonIgnore
	@ManyToMany(mappedBy="groups", fetch=FetchType.EAGER)
	private Set<User> users;
	
	
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="group_authority"
		, joinColumns={
			@JoinColumn(name="group_group_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="authority_authority_id")
			}
		)
	private Set<Authority> authorities;



	public int getGroupId() {
		return groupId;
	}



	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}



	public String getGroupName() {
		return groupName;
	}



	public void setGroupName(String groupName) {
		this.groupName = groupName;
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



	public Set<User> getUsers() {
		return users;
	}



	public void setUsers(Set<User> users) {
		this.users = users;
	}



	public Set<Authority> getAuthorities() {
		return authorities;
	}



	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	
		
	
	
}
