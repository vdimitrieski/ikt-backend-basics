package com.iktpreobuka.t3.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.t3.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
