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
import javax.persistence.ManyToMany;
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

	@ManyToMany(mappedBy="authorities", fetch=FetchType.EAGER)
	private Set<Group> groups;
	
	
	
}
