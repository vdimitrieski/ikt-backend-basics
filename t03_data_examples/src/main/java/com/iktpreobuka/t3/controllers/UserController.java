package com.iktpreobuka.t3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.t3.entities.AddressEntity;
import com.iktpreobuka.t3.entities.UserEntity;
import com.iktpreobuka.t3.repositories.AddressRepository;
import com.iktpreobuka.t3.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@RequestMapping(method = RequestMethod.POST)
	public UserEntity saveNewUser(@RequestParam String name, @RequestParam String email) {
		// create new user
		UserEntity newUser = new UserEntity();
		newUser.setEmail(email);
		newUser.setName(name);
		// store user in DB
		userRepository.save(newUser);
		return newUser;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<UserEntity> getAllUsers() {
		return (List<UserEntity>) userRepository.findAll();
	}

	@RequestMapping(path = "/{id}/address", method = RequestMethod.PUT)
	public UserEntity addAddressToUser(@PathVariable Integer id, @RequestParam Integer addressId) {
		// find user by id
		UserEntity userEntity = userRepository.findById(id).get();
		// find address by id
		AddressEntity addressEntity = addressRepository.findById(addressId).get();
		// combine these two
		userEntity.setAddress(addressEntity);
		// save user and address
		return userRepository.save(userEntity);
	}

}
