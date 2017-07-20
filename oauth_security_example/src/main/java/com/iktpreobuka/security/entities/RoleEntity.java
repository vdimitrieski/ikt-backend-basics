package com.iktpreobuka.security.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class RoleEntity {
	
	
	private Integer id;
	
	private String name;
	
	@JsonIgnore 
	private List<UserEntity> users = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//get, set methods, constructors
	
}
