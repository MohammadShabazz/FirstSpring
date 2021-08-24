package com.example.demo.modal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity

@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	
	@Enumerated(EnumType.STRING)
	@NaturalId
	private RoleName role;


	public Role() {
		super();
	}


	public Role(Long id, RoleName role) {
		super();
		this.id = id;
		this.role = role;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public RoleName getRole() {
		return role;
	}


	public void setRole(RoleName role) {
		this.role = role;
	}
	
	
	
	
}
