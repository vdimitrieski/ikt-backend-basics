package com.iktpreobuka.t6.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.t6.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
