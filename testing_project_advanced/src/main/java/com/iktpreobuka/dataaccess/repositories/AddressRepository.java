package com.iktpreobuka.dataaccess.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dataaccess.entities.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {

}
