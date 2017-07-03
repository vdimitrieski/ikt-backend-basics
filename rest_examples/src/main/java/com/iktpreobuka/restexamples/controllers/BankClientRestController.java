package com.iktpreobuka.restexamples.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.restexamples.entities.BankClientBean;

@RestController
@RequestMapping("/bankclients")
public class BankClientRestController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<BankClientBean> getAll() {
		List<BankClientBean> clients = new ArrayList<BankClientBean>();
		clients.add(new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs"));
		clients.add(new BankClientBean(2, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs"));
		return clients;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/client")
	public BankClientBean getByNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
		if(name.equals("Milan") && surname.equals("Celikovic"))
			return new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs");
		else 
			return new BankClientBean();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
	public BankClientBean getById(@PathVariable String clientId) {
		if(clientId.equals("1"))
			return new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs");
		else
			return new BankClientBean();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String add(@RequestBody BankClientBean client) {
		System.out.println(client.getName().concat(" ").concat(client.getSurname()));
		return "New client added";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{clientId}")
	public BankClientBean delete(@PathVariable String clientId) {
		if(clientId.equals("1"))
			return new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs");
		else
			return new BankClientBean();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{clientId}")
	public BankClientBean modify(@PathVariable String clientId, @RequestBody BankClientBean client) {
		if(clientId.equals("1"))
			return new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs");
		else
			return client;
	}
	
	//Zadatak 1.1
	@RequestMapping(method = RequestMethod.GET, value = "/emails")
	public List<String> getEmails() {
		List<BankClientBean> clients = new ArrayList<BankClientBean>();
		clients.add(new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs"));
		clients.add(new BankClientBean(2, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs"));
				
		List<String> emails = new ArrayList<String>();
		for(int i = 0;i<clients.size();i++)
			emails.add(clients.get(i).getEmail());
		
		return emails;
	}
	
	//Zadatak 1.2
	@RequestMapping(method = RequestMethod.GET, value = "/clients/{firstLetter}")
	public List<String> getNamesByFirstLetter(@PathVariable String firstLetter) {
		List<BankClientBean> clients = new ArrayList<BankClientBean>();
		clients.add(new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs"));
		clients.add(new BankClientBean(2, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs"));
			
		List<String> names = new ArrayList<String>();
		for(int i = 0;i<clients.size();i++)
			if(clients.get(i).getName().substring(0,1).equals(firstLetter))
				names.add(clients.get(i).getName());
		
		return names;
	}
	
	//Zadatak 1.3
	@RequestMapping(method = RequestMethod.GET, value = "/clients/firstLetters")
	public List<String> getNameAndSurnameByFirstLetter(@RequestParam("nameFirstLetter") String nameFirstLetter, @RequestParam("surnameFirstLetter") String surnameFirstLetter) {
		List<BankClientBean> clients = new ArrayList<BankClientBean>();
		clients.add(new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs"));
		clients.add(new BankClientBean(2, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs"));
			
		List<String> namesAndSurnames = new ArrayList<String>();
		for(int i = 0;i<clients.size();i++)
			if(clients.get(i).getName().substring(0,1).equals(nameFirstLetter) && clients.get(i).getSurname().substring(0,1).equals(surnameFirstLetter))
				namesAndSurnames.add(clients.get(i).getName().concat(" ").concat(clients.get(i).getSurname()));
		
		return namesAndSurnames;
	}
	
	//Zadatak 1.4
	@RequestMapping(method = RequestMethod.GET, value = "/clients/sort/{order}")
	public List<String> getNamesSorted(@PathVariable String order) {
		List<BankClientBean> clients = new ArrayList<BankClientBean>();
		clients.add(new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs"));
		clients.add(new BankClientBean(2, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs"));
		
		List<String> names = new ArrayList<String>();
		for(int i = 0;i<clients.size();i++)
				names.add(clients.get(i).getName());
		
		if(order.equals("A"))
			Collections.sort(names); //ASC
		else if(order.equals("D"))
			Collections.sort(names, Collections.reverseOrder()); //DESC
		else
			names = new ArrayList<String>();
		
		return names;
	}
}
