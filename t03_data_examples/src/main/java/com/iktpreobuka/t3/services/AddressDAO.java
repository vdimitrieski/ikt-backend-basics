package com.iktpreobuka.t3.services;

import java.util.List;

import com.iktpreobuka.t3.entities.AddressEntity;

public interface AddressDAO {
	public List<AddressEntity> findAddressesByUserName(String name);
}
