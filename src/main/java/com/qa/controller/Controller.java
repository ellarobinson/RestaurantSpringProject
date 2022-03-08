package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.Customer;
import com.qa.service.CustomerService;

@RestController
public class Controller {
	
	private CustomerService service;

	@Autowired
	public Controller(CustomerService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(this.service.createCustomer(customer), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> readAllCustomers() {
		return new ResponseEntity<List<Customer>>(this.service.readAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Customer> readCustomerById(@PathVariable Integer id) {
		return new ResponseEntity<Customer>(this.service.readCustomerById(id), HttpStatus.OK);
	}

}
