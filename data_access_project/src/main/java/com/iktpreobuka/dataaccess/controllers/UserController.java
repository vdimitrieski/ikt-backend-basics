package com.iktpreobuka.dataaccess.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	public UserEntity addNewUser(@RequestParam String name, @RequestParam String email) {
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

	// zadatak 1.2
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public UserEntity findById(@PathVariable Integer id) {
		return userRepository.findOne(id);
	}

	// zadatak 1.2
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public UserEntity updateUser(@PathVariable Integer id, @RequestParam String name, @RequestParam String email) {
		UserEntity user = userRepository.findOne(id);
		if (name != null) {
			user.setName(name);
		}
		if (email != null) {
			user.setEmail(email);
		}
		user = userRepository.save(user);
		return user;
	}

	// zadatak 1.2
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public UserEntity deleteUser(@PathVariable Integer id) {
		UserEntity user = userRepository.findOne(id);
		userRepository.delete(id);
		return user;
	}

	// zadatak 1.3
	@RequestMapping(method = RequestMethod.GET, value = "/by-email")
	public UserEntity findByEmail(@RequestParam String email) {
		return userRepository.findFirstByEmail(email);
	}

	// zadatak 1.4
	@RequestMapping(method = RequestMethod.GET, value = "/by-name")
	public UserEntity findByName(@RequestParam String name) {
		return userRepository.findFirstByName(name);
	}

}
