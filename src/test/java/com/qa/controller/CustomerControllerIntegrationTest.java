package com.qa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entity.Customer;

@SpringBootTest
@ActiveProfiles("test")

@AutoConfigureMockMvc
public class CustomerControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createCustomer() throws Exception {
		Customer customer1 = new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		String customer1JSON = this.mapper.writeValueAsString(customer1);
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(customer1JSON);
		ResultMatcher resultStatus = status().isCreated();
		ResultMatcher resultContent = content().json(customer1JSON);
		this.mvc.perform(request).andExpect(resultStatus).andExpect(resultContent);
	}

}
