package com.iktpreobuka.t5.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegisterDTO {
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;

	// get, set, constructors

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

	public UserRegisterDTO() {
		super();
	}

}
