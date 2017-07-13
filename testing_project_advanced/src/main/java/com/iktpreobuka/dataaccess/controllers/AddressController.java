package com.iktpreobuka.dataaccess.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.AddressEntity;
import com.iktpreobuka.dataaccess.repositories.AddressRepository;
import com.iktpreobuka.dataaccess.services.AddressDao;

@RestController
@RequestMapping(path = "/api/v1/addresses")
public class AddressController {
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AddressDao addressDao;
	
	@RequestMapping(method = RequestMethod.POST)
	public AddressEntity addNewAddress(@RequestParam String street, @RequestParam String city,
			@RequestParam String country) {
		AddressEntity address = new AddressEntity();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		addressRepository.save(address);
		return address;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{name}")
	public List<AddressEntity> addAddressToAUser(@PathVariable String name) {
		return addressDao.findAdressesByUserName(name);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<AddressEntity> getAllAddresses() {
		return addressRepository.findAll();
	}
}
