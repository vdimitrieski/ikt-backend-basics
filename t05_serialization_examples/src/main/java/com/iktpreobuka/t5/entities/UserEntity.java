package com.iktpreobuka.t5.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.t5.security.Views;

@JsonRootName("test")
public class UserEntity {
	@JsonView(Views.Public.class)
	@JsonProperty("ID")
	private Integer id;
	@JsonView(Views.Public.class)
	private String name;
	@JsonView(Views.Admin.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date dateOfBirth;
	@JsonView(Views.Admin.class)
	private String email;
	@JsonIgnore
	private String password;
	private Integer version;
	@JsonView(Views.Private.class)
	@JsonManagedReference
	private AddressEntity address;

	// getters and setters

	public AddressEntity getAddress() {
		return address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public UserEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
