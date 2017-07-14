package com.iktpreobuka.tourofheroes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.tourofheroes.entities.HeroEntity;
import com.iktpreobuka.tourofheroes.repositories.HeroRepository;

@RestController
@RequestMapping("/api/v1/hero")
@CrossOrigin
public class HeroController {

	@Autowired
	private HeroRepository heroRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getHeroes() {
		return new ResponseEntity<List<HeroEntity>>((List<HeroEntity>) heroRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getHeroById(@PathVariable Integer id) {
		HeroEntity heroDB = heroRepository.findOne(id);
		return new ResponseEntity<HeroEntity>(heroDB, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveHero(@RequestBody HeroEntity hero) {
		heroRepository.save(hero);
		return new ResponseEntity<HeroEntity>(hero, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateHero(@PathVariable Integer id, @RequestBody HeroEntity hero) {
		HeroEntity heroDB = heroRepository.findOne(id);
		heroDB.setName(hero.getName());
		heroRepository.save(heroDB);
		return new ResponseEntity<HeroEntity>(heroDB, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteHero(@PathVariable Integer id) {
		HeroEntity heroDB = heroRepository.findOne(id);
		heroRepository.delete(id);
		return new ResponseEntity<HeroEntity>(heroDB, HttpStatus.OK);
	}

}
