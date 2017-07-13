package com.iktpreobuka.dataaccess;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.iktpreobuka.dataaccess.controllers.UserController;
import com.iktpreobuka.dataaccess.entities.AddressEntity;
import com.iktpreobuka.dataaccess.entities.UserEntity;
import com.iktpreobuka.dataaccess.repositories.AddressRepository;
import com.iktpreobuka.dataaccess.repositories.UserRepository;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class UserControllerTests {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	private static MockMvc mockMvc;
	
	@Autowired
    private  WebApplicationContext webApplicationContext;
	
    private  static AddressEntity address;

    private  static List<UserEntity> users = new ArrayList<>();
	
	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private  AddressRepository  addressRepository;
	
	private static boolean dbInit = false;
	
	@Before
    public   void setup() throws Exception {
		if(!dbInit) {
			 mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			 address = this.addressRepository.save(new AddressEntity("Main Street", "New York", "USA", null));
			 users.add(this.userRepository.save(new UserEntity("Peter", "peter@mail", address)));
			 users.add(this.userRepository.save(new UserEntity("John", "john@mail", address)));
			 users.add(this.userRepository.save(new UserEntity("Paul", "paul@mail", address)));
			 dbInit = true;
		}
	}
	
	@Test
    public void userServiceNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/userss/1"))
                .andExpect(status().isNotFound());
    }
	
	@Test
    public void userServiceFound() throws Exception {
        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk());
    }
	
	@Test
    public void readSingleUser() throws Exception {
        mockMvc.perform(get("/api/v1/users/"
                + users.get(0).getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(users.get(0).getId().intValue())));
    }
	
	
	
	@Test
    public void readAllUsers() throws Exception {
        mockMvc.perform(get("/api/v1/users/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andDo(MockMvcResultHandlers.print());
                
    }
	
	@Test
    public void createUser() throws Exception {	

        mockMvc.perform(post("/api/v1/users/")
                .param("name", "Nick")
                .param("email", "nick@mail"))
                .andExpect(status().isOk())
		        .andExpect(content().contentType(contentType))
		        .andExpect(jsonPath("$.name", is("Nick")));
    }
    
    @Test
    public void deleteUser() throws Exception {
    	
    	mockMvc.perform(delete("/api/v1/users/"
                + users.get(1).getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(users.get(0).getId().intValue())));
    }
    
    @Test
    public void updateUser() throws Exception {
    	
    	mockMvc.perform(put("/api/v1/users/"
                + this.users.get(0).getId())
		    	.param("name", "Pera")
		        .param("email", "pera@mail"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.name", is("Pera")))
                .andExpect(jsonPath("$.email", is("pera@mail")));
    }

}
