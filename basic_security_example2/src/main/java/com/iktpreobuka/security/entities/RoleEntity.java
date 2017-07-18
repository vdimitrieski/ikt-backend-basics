package com.iktpreobuka.security.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class RoleEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private Integer id;
	@Column(name="role_name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
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
