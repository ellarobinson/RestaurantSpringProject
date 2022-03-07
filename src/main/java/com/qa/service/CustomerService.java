package com.qa.service;

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
	
	
	

}
