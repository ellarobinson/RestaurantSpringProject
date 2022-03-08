package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entity.Customer;
import com.qa.repo.CustomerRepo;

@Service
public class CustomerService {
	
	private CustomerRepo repo;
	
	@Autowired
	public CustomerService(CustomerRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Customer createCustomer(Customer customer) {
		return this.repo.save(customer);
	}
	
	public List<Customer> readAllCustomers() {
		return this.repo.findAll();
	}
	
	public Customer readCustomerById(int customerId) {
		return this.repo.findById(customerId).orElseThrow();
	}
	
	public List<Customer> readCustomersByName(String name) {
		return this.repo.findByName(name);
	}
	

}
