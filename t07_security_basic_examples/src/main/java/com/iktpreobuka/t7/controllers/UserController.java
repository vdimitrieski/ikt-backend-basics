package com.iktpreobuka.t7.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.t7.entities.RoleEntity;
import com.iktpreobuka.t7.entities.UserEntity;

@RestController
public class UserController {

	public List<UserEntity> getDummyDB() {
		List<UserEntity> list = new ArrayList<>();

		RoleEntity re = new RoleEntity();
		re.setId(1);
		re.setName("admin");

		UserEntity ue = new UserEntity();
		ue.setId(1);
		ue.setEmail("user@example.com");
		ue.setName("Vladimir");
		ue.setLastname("Dimitrieski");
		ue.setPassword("password1234");
		ue.setRole(re);
		UserEntity ue1 = new UserEntity();
		ue1.setId(2);
		ue1.setEmail("user2@example.com");
		ue1.setName("Milan");
		ue1.setLastname("Celikovic");
		ue1.setPassword("password4321");
		ue1.setRole(re);

		list.add(ue);
		list.add(ue1);

		return list;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, path = "/api/v1/users")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<List<UserEntity>>(getDummyDB(), HttpStatus.OK);
	}

}
