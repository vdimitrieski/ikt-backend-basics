package com.iktpreobuka.tourofheroes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.tourofheroes.entities.HeroEntity;

public interface HeroRepository extends CrudRepository<HeroEntity, Integer>{

}
