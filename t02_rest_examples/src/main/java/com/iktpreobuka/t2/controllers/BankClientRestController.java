package com.iktpreobuka.t2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.t2.entities.BankClientEntity;


@RestController
@RequestMapping("/bankclients")
public class BankClientRestController {

	private List<BankClientEntity> getDB() {
		List<BankClientEntity> lista = new ArrayList<>();
		BankClientEntity b1 = new BankClientEntity(1L, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs");
		BankClientEntity b2 = new BankClientEntity(2L, "Milan", "Celikovic", "milancel@uns.ac.rs");
		lista.add(b1);
		lista.add(b2);
		return lista;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<BankClientEntity> getAllBankClients() {
		List<BankClientEntity> lista = getDB();
		return lista;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
	public BankClientEntity getSingleClientByID(@PathVariable String clientId) {
		if (clientId.equals("1")) {
			BankClientEntity b1 = new BankClientEntity(1L, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs");
			return b1;
		} else if (clientId.equals("2")) {
			return new BankClientEntity(2L, "Milan", "Celikovic", "milancel@uns.ac.rs");
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public BankClientEntity createNewClient(@RequestBody BankClientEntity newBankClient) {
		System.out.println(newBankClient.toString());
		return newBankClient;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{clientId}")
	public BankClientEntity updateClient(@PathVariable String clientId, 
				@RequestBody BankClientEntity updClient) {
		BankClientEntity b1 = new BankClientEntity(1L, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs");
		if (clientId.equals("1")) {
			b1.setName(updClient.getName());
			return b1;
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{clientId}")
	public BankClientEntity deleteClient(@PathVariable Long clientId) {
		//baza podataka
		List<BankClientEntity> lista = new ArrayList<>();
		BankClientEntity b1 = new BankClientEntity(1L, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs");
		BankClientEntity b2 = new BankClientEntity(2L, "Milan", "Celikovic", "milancel@uns.ac.rs");
		lista.add(b1);
		lista.add(b2);
		
		//logika brisanja
		if(clientId.equals(1L)) {
			lista.remove(b1);
			return b1;
		} else if(clientId.equals(2L)) {
			lista.remove(b2);
			return b2;
		}
		
		return null;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/client")
	public BankClientEntity getByNameAndSurname(@RequestParam("surname") String surname, 
			@RequestParam("name") String name) {
		
		if(name.equals("Milan") && surname.equals("Celikovic")) {
			return new BankClientEntity(2L, "Milan", "Celikovic", "milancel@uns.ac.rs");
		}
		
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/emails")
	public List<String> getEmails() {
		//korak 1 napravili prazan spisak emailova
		List<String> emails = new ArrayList<>();
		
		//korak 2 - nabaviti sve klijente
		List<BankClientEntity> clients = getDB();
		//korak 3 - proci kroz sve klijente
		for (int i = 0; i < clients.size(); i++) {
			//korak 3.1 - za svakog klijenta preuzeti njegov email
			String clientEmail = clients.get(i).getEmail();
			emails.add(clientEmail);
		}

		
		//korak poslednji - vrati emailove
		return emails;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/clients/{firstLetter}")
	public List<String> getNamesByFirstLetter(@PathVariable String firstLetter) {
		//#1 kreiraj spisak imena
		List<String> names = new ArrayList<>();
		//#2 dobavi klijente
		List<BankClientEntity> clients = getDB();
		//#3 prodji korz sve klijente
		for (BankClientEntity bankClient : clients) {
			//#3.1 sa svakog klijenta pronadji ime
			String name = bankClient.getName();
			//#3.2 vidi da li ime pocinje sa trazenim slovom
			if (name.startsWith(firstLetter)) {
				//#3.3 ako pocinje, zapamti to ime
				names.add(name);
			}			
		}
			
		//#4 vrati spisak imena
		return names;
	}

}
