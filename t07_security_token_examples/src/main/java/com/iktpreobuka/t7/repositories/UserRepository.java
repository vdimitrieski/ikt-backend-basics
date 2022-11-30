package com.iktpreobuka.t7.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.t7.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	public UserEntity findByEmail(String email);
}
