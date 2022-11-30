package com.iktpreobuka.t10;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iktpreobuka.t10.controllers.HomeController;

@SpringBootTest
public class AssertExampleTest {

	@Autowired
	private HomeController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}