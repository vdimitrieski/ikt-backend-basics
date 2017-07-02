package com.iktpreobuka.dataaccess.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dataaccess.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	UserEntity findFirstByEmail(String email);

	UserEntity findFirstByName(String name);
}
