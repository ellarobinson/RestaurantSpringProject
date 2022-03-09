package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entity.Customer;
import com.qa.exceptions.CustomerNotFoundException;
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
		return this.repo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found by that id."));
	}
	
	public List<Customer> readCustomersByName(String name) {
		return this.repo.findByName(name);
	}
	
	public Customer readCustomerByPhone(String phone) {
		return this.repo.findByPhone(phone);
	}
	
	public Customer updateCustomer(int customerId, Customer customer) {
		Customer foundCustomer = this.readCustomerById(customerId);
		foundCustomer.setName(customer.getName());
		foundCustomer.setAge(customer.getAge());
		foundCustomer.setPhone(customer.getPhone());
		foundCustomer.setEmail(customer.getEmail());
		foundCustomer.setAddress(customer.getAddress());
		foundCustomer.setNumOfVisits(customer.getNumOfVisits());
		return this.repo.save(foundCustomer);
	}
	
	public boolean deleteCustomer(int customerId) {
		this.repo.deleteById(customerId);
		return !this.repo.existsById(customerId);
	}

}
