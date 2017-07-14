package com.iktpreobuka.tourofheroes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class HeroEntity {
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;

	@JsonProperty("Name")
	private String name;

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

	public HeroEntity() {
		super();
	}

}
