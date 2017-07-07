package com.iktpreobuka.dataaccess.services;

import java.util.List;

import com.iktpreobuka.dataaccess.entities.AddressEntity;

public interface AddressDao {
	
	public List<AddressEntity> findAdressesByUserName(String name);
	

}
