package com.iktpreobuka.security.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserEntity {


	private Integer id;
	
	private String email;
	
	@JsonIgnore 
	private String password;
	
	private String name;
	
	private String lastName;
	
		
	
	private RoleEntity role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	

}