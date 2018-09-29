package com.key.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Type;
import org.hibernate.type.AdaptedImmutableType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.key.configuration.AuditListener;
import com.key.configuration.Auditable;


//@EntityListeners(AuditListener.class)
@Entity
@Table(name = "user")
public class User extends Auditable<Integer> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;

	@Column(name = "firstname")
	@NotEmpty(message = "*Please provide your name")
	private String name;

	@Column(name = "lastname")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Column(name = "active")
	private int active;

	@Column(name = "activation_keyword")
	private String keyword;


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="user_group"
		, joinColumns={
			@JoinColumn(name="user_user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="group_group_id")
			}
		)
	private Set<Group> groups;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

		

}
