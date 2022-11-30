package com.iktpreobuka.t6.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue
	private Integer id;

	@NotBlank(message = "First name has to be provided.")
	@Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.")
	@Column(nullable = false)
	private String firstName;

	@NotBlank(message = "Last name has to be provided.")
	@Size(min = 2, max = 30, message = "Last name must be between {min} and {max} characters long.")
	@Column(nullable = false)
	private String lastName;

	@NotBlank(message = "Email has to be provided.")
	@Email(message = "Email is not valid.")
	@Column(nullable = false)
	private String email;

	@NotBlank(message = "Username has to be provided.")
	@Size(min = 5, max = 15, message = "Username must be between {min} and {max} characters long.")
	@Column(nullable = false, unique = true)
	private String username;

	@NotBlank(message = "Password has to be provided.")
	@Size(min = 5, max = 10, message = "Password must be between {min} and {max} characters long.")
	@Column(nullable = false)
	private String password;

	@Transient
	private String confirmPassword;

	@NotNull(message = "Age has to be provided.")
	@Min(value = 18, message = "User must be an adult.")
	@Column(nullable = false)
	private Integer age;

	@Version
	private Integer version;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
