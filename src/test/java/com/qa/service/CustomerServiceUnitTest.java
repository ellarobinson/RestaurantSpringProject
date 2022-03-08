package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.entity.Customer;
import com.qa.repo.CustomerRepo;

@SpringBootTest
public class CustomerServiceUnitTest {
	
	@Autowired
	private CustomerService service;
	
	@MockBean
	private CustomerRepo repo;
	
	@Test
	public void createCustomerTest() {
		Customer newCustomer = new Customer("Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Customer savedCustomer = new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Mockito.when(this.repo.save(newCustomer)).thenReturn(savedCustomer);
		assertThat(this.service.createCustomer(newCustomer)).isEqualTo(savedCustomer);
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Customer.class));
	}
	
	@Test
	public void getAllCustomersTest() {
		Customer customer1 = new Customer("Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Customer customer2 = new Customer("Tracey", 53, "07843964920", "tracey@gmail.com", "2 Example Street", 3);
		Mockito.when(this.repo.findAll()).thenReturn(List.of(customer1, customer2));
		assertThat(this.service.readAllCustomers()).isEqualTo(List.of(customer1, customer2));
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getCustomerByIdTest() {
		int id = 1;
		Customer customer1 = new Customer("Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(customer1));
		assertThat(this.service.readCustomerById(id)).isEqualTo(customer1);
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyInt());
	}
	
	
	
	
	

}
