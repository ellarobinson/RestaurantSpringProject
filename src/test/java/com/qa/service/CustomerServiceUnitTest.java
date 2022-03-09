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
	public void readAllCustomersTest() {
		Customer customer1 = new Customer("Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Customer customer2 = new Customer("Tracey", 53, "07843964920", "tracey@gmail.com", "2 Example Street", 3);
		Mockito.when(this.repo.findAll()).thenReturn(List.of(customer1, customer2));
		assertThat(this.service.readAllCustomers()).isEqualTo(List.of(customer1, customer2));
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void readCustomerByIdTest() {
		int id = 1;
		Customer customer1 = new Customer("Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(customer1));
		assertThat(this.service.readCustomerById(id)).isEqualTo(customer1);
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyInt());
	}
	
	@Test
	public void readCustomerByNameTest() {
		String name = "Mark";
		Customer customer1 = new Customer("Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Customer customer2 = new Customer("Mark", 53, "07740173604", "mark@yahoo.com", "3 Example Street", 73);
		Mockito.when(this.repo.findByName(name)).thenReturn(List.of(customer1, customer2));
		assertThat(this.service.readCustomersByName(name)).isEqualTo(List.of(customer1, customer2));
		Mockito.verify(this.repo, Mockito.times(1)).findByName(name);
	}
	
	@Test
	public void readCustomerByPhoneTest() {
		String phone = "07384916302";
		Customer customer = new Customer("Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Mockito.when(this.repo.findByPhone(phone)).thenReturn(customer);
		assertThat(this.service.readCustomerByPhone(phone)).isEqualTo(customer);
		Mockito.verify(this.repo, Mockito.times(1)).findByPhone(Mockito.anyString());
	}
	
	@Test
	public void updateCustomerTest() {
		int id = 1;
		Customer savedCustomer = new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Customer updatingCustomer = new Customer("Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 8);
		Customer updatedCustomer = new Customer(1, "Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 8);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(savedCustomer));
		Mockito.when(this.repo.save(updatedCustomer)).thenReturn(updatedCustomer);
		assertThat(this.service.updateCustomer(id, updatingCustomer)).isEqualTo(updatedCustomer);
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyInt());
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Customer.class));
	}
	
	@Test
	public void deleteCustomerTest() {
		int id = 1;
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		assertThat(this.service.deleteCustomer(id)).isEqualTo(true);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(Mockito.anyInt());
		Mockito.verify(this.repo, Mockito.times(1)).existsById(Mockito.anyInt());
	}
	
	
	

}
