package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	
	List<Customer> findByName(String name);
	
	Customer findByPhone(String phone);

}
