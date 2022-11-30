package com.iktpreobuka.t3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.t3.entities.AddressEntity;
import com.iktpreobuka.t3.repositories.AddressRepository;
import com.iktpreobuka.t3.services.AddressDAO;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AddressDAO addressDAO;

	@RequestMapping
	public List<AddressEntity> getAll() {
		return (List<AddressEntity>) addressRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public AddressEntity saveNewAddress(@RequestParam String street, @RequestParam String city,
			@RequestParam String country) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setStreet(street);
		addressEntity.setCity(city);
		addressEntity.setCountry(country);
		return addressRepository.save(addressEntity);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/user/{name}")
	public List<AddressEntity> findAddressByUserName(@PathVariable String name) {
		return addressDAO.findAddressesByUserName(name);
	}

}
