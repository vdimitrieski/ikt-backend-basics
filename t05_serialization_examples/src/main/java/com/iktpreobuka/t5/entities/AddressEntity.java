package com.iktpreobuka.t5.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.t5.security.Views;

public class AddressEntity {

	@JsonView(Views.Admin.class)
	private Integer id;
	@JsonView(Views.Admin.class)
	private String street;
	@JsonView(Views.Admin.class)
	private String city;
	@JsonView(Views.Admin.class)
	private String country;
	private Integer version;

	@JsonBackReference
	private List<UserEntity> users = new ArrayList<>();

	// getters and setters

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public AddressEntity() {
		super();
	}

}
