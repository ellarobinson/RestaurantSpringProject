package com.qa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entity.Customer;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = {"classpath:customer-schema.sql", "classpath:customer-data.sql"},
	executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void createCustomerTest() throws Exception {
		Customer newCustomer = new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		String newCustomerJSON = this.mapper.writeValueAsString(newCustomer);
		Customer savedCustomer = new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		String savedCustomerJSON = this.mapper.writeValueAsString(savedCustomer);
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(newCustomerJSON);
		ResultMatcher resultStatus = status().isCreated();
		ResultMatcher resultContent = content().json(savedCustomerJSON);
		this.mvc.perform(request).andExpect(resultStatus).andExpect(resultContent);
	}
	
	@Test
	void readAllCustomersTest() throws Exception {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7));
		customers.add(new Customer(2, "Tracey", 53, "07843964920", "tracey@gmail.com", "2 Example Street", 3));
		customers.add(new Customer(3, "Mark", 53, "07740173604", "mark@yahoo.com", "3 Example Street", 73));
		String customersJSON = this.mapper.writeValueAsString(customers);
		RequestBuilder request = get("/getAll");
		ResultMatcher resultStatus = status().isOk();
		ResultMatcher resultContent = content().json(customersJSON);
		this.mvc.perform(request).andExpect(resultStatus).andExpect(resultContent);
	}
	
	@Test
	void readCustomerByIdTest() throws Exception {
		Customer customer = new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		String customerJSON = this.mapper.writeValueAsString(customer);
		RequestBuilder request = get("/getById/1");
		ResultMatcher resultStatus = status().isOk();
		ResultMatcher resutContent = content().json(customerJSON);
		this.mvc.perform(request).andExpect(resultStatus).andExpect(resutContent);
	}
	
	@Test
	void readCustomersByNameTest() throws Exception {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7));
		customers.add(new Customer(3, "Mark", 53, "07740173604", "mark@yahoo.com", "3 Example Street", 73));
		String customersJSON = this.mapper.writeValueAsString(customers);
		RequestBuilder request = get("/getByName/Mark");
		ResultMatcher resultStatus = status().isOk();
		ResultMatcher resultContent = content().json(customersJSON);
		this.mvc.perform(request).andExpect(resultStatus).andExpect(resultContent);
	}
	
	@Test
	void readCustomerByPhone() throws Exception {
		Customer customer = new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		String customerJSON = this.mapper.writeValueAsString(customer);
		RequestBuilder request = get("/getByPhone/07384916302");
		ResultMatcher resultStatus = status().isOk();
		ResultMatcher resutContent = content().json(customerJSON);
		this.mvc.perform(request).andExpect(resultStatus).andExpect(resutContent);
	}
	
	
	
	

}
