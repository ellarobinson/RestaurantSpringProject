package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
