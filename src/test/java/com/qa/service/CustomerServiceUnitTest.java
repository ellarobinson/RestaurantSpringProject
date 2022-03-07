package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;

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
		Customer customer1 = new Customer("Mark", 53, "07384916302", "mark@gmail.com", "1 Example Street", 7);
		Mockito.when(this.repo.save(customer1)).thenReturn(customer1);
		assertThat(this.service.createCustomer(customer1)).isEqualTo(customer1);
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Customer.class));
	}

}
