package com.iktpreobuka.security.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iktpreobuka.security.entities.RoleEntity;
import com.iktpreobuka.security.entities.UserEntity;



@Controller
public class UserController {
	
	/*@Autowired
	private UserRepository userRep;
	
	@Autowired
	private RoleRepository roleRep;*/
	
	public List<UserEntity> getDummyDB() {
		List<UserEntity> list = new ArrayList<>();

		RoleEntity re = new RoleEntity();
		re.setId(1);
		re.setName("admin");
		
		//roleRep.save(re);
		
		UserEntity ue = new UserEntity();
		ue.setId(1);
		ue.setEmail("user@example.com");
		ue.setName("Vladimir");
		ue.setLastName("Dimitrieski");
		ue.setPassword("pass");
		ue.setRole(re);
		
		//userRep.save(ue);

		UserEntity ue1 = new UserEntity();
		ue1.setId(2);
		ue1.setEmail("user2@example.com");
		ue1.setName("Milan");
		ue1.setLastName("Celikovic");
		ue1.setPassword("pass");
		ue1.setRole(re);

		//userRep.save(ue1);

		list.add(ue);
		list.add(ue1);

		return list;
	}
	
	
	@RequestMapping(path="/users", method = RequestMethod.GET)
	public ResponseEntity<?>  listUsers(){
		return new ResponseEntity<List<UserEntity>>(getDummyDB(), HttpStatus.OK);
	}

	
}
