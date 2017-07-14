package com.iktpreobuka.serialization.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.serialization.controllers.util.RESTError;
import com.iktpreobuka.serialization.entities.AddressEntity;
import com.iktpreobuka.serialization.entities.UserEntity;
import com.iktpreobuka.serialization.entities.dto.UserRegisterDTO;
import com.iktpreobuka.serialization.security.Views;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	public List<UserEntity> getDummyDB() {
		List<UserEntity> list = new ArrayList<>();

		AddressEntity addr = new AddressEntity();
		addr.setId(1);
		addr.setStreet("Glavna Ulica 1");
		addr.setCity("Novi Sad");
		addr.setCountry("Srbija");

		UserEntity ue = new UserEntity();
		ue.setId(1);
		ue.setDateOfBirth(new Date());
		ue.setEmail("user@example.com");
		ue.setName("Vladimir");
		ue.setPassword("password1234");
		ue.setVersion(0);
		ue.setAddress(addr);

		UserEntity ue1 = new UserEntity();
		ue1.setId(2);
		ue1.setDateOfBirth(new Date());
		ue1.setEmail("user2@example.com");
		ue1.setName("Milan");
		ue1.setPassword("password4321");
		ue1.setVersion(0);
		ue1.setAddress(addr);

		addr.getUsers().add(ue);
		addr.getUsers().add(ue1);

		list.add(ue);
		list.add(ue1);

		return list;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/public")
	@JsonView(Views.Public.class)
	public List<UserEntity> getAllUsers() {
		return getDummyDB();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/private")
	@JsonView(Views.Private.class)
	public List<UserEntity> getAllUsersForPrivate() {
		return getDummyDB();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/admin")
	@JsonView(Views.Admin.class)
	public List<UserEntity> getAllUsersForAdmin() {
		return getDummyDB();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@JsonView(Views.Admin.class)
	public ResponseEntity<?> getUserByID(@PathVariable Integer id) {
		try {
			List<UserEntity> users = getDummyDB();
			for (UserEntity userEntity : users) {
				if (userEntity.getId().equals(id)) {
					// ako je korisnik pronadjen vratiti 200
					return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
				}
			}
			// ako korisnik nije pronadjen vratiti 404
			return new ResponseEntity<RESTError>(new RESTError(1, "User not found"), HttpStatus.NOT_FOUND);
		} catch (Exception e) { // u slucaju izuzetka vratiti 500
			return new ResponseEntity<RESTError>(new RESTError(2, "Exception occurred: " + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserRegisterDTO user) {
		UserEntity ue = new UserEntity();
		ue.setId(3);
		ue.setEmail(user.getEmail());
		ue.setName(user.getName());
		return new ResponseEntity<UserEntity>(ue, HttpStatus.OK);
	}

}
