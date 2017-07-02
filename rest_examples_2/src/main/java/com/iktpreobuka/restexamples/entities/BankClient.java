package com.iktpreobuka.restexamples.entities;

public class BankClient {
	private Long id;
	private String name;
	private String surname;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BankClient() {
		super();
	}

	public BankClient(Long id, String name, String surname, String email) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	@Override
	public String toString() {
		return "BankClient [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
	
	

}
