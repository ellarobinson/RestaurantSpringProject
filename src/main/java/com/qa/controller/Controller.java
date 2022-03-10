package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Customer>> readCustomersByName(@PathVariable String name) {
		return new ResponseEntity<List<Customer>>(this.service.readCustomersByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/getByPhone/{phone}")
	public ResponseEntity<Customer> readCustomerByPhone(@PathVariable String phone) {
		return new ResponseEntity<Customer>(this.service.readCustomerByPhone(phone), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(this.service.updateCustomer(id, customer), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable Integer id) {
		boolean deleted = this.service.deleteCustomer(id);
		if(deleted) {
			return new ResponseEntity<Boolean>(deleted, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Boolean>(deleted, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("updateVisit/{id}")
	public ResponseEntity<Customer> updateCustomerVisit(@PathVariable Integer id) {
		return new ResponseEntity<Customer>(this.service.updateCustomerVisit(id), HttpStatus.ACCEPTED);
	}

}
