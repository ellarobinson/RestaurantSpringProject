package com.qa.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	
	private String name;
	private int age;
	private String phone;
	private String email;
	private String address;
	private int numOfVisits;
	
	public Customer() {}

	public Customer(String name, int age, String phone, String email, String address, int numOfVisits) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.numOfVisits = numOfVisits;
	}

	public Customer(int customer_id, String name, int age, String phone, String email, String address,
			int numOfVisits) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.numOfVisits = numOfVisits;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumOfVisits() {
		return numOfVisits;
	}

	public void setNumOfVisits(int numOfVisits) {
		this.numOfVisits = numOfVisits;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, customer_id, email, name, numOfVisits, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && age == other.age && customer_id == other.customer_id
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& numOfVisits == other.numOfVisits && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", age=" + age + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", numOfVisits=" + numOfVisits + "]";
	}
	
	

}