package com.iktpreobuka.dataaccess.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.UserEntity;
import com.iktpreobuka.dataaccess.repositories.UserRepository;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST)
	public UserEntity addNewUser(@RequestParam String name, 
			@RequestParam String email) {
		UserEntity user = new UserEntity();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		return user;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

}
