package com.iktpreobuka.t3.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.t3.entities.AddressEntity;

@Service
public class AddressDAOImpl implements AddressDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<AddressEntity> findAddressesByUserName(String name) {

		// create sql to invoke
		String sql = "SELECT a FROM AddressEntity a LEFT JOIN FETCH a.users u WHERE u.name = :name";

		// invoke the SQL statement
		Query query = em.createQuery(sql);
		query.setParameter("name", name);

		List<AddressEntity> retVal = query.getResultList();

		// handle the return value of the SQL statement
		return retVal;
	}

}
