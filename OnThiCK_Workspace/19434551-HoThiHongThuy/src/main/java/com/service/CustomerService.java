package com.service;

import java.util.List;

import com.entity.Customer;

public interface CustomerService {
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public Customer findCustomerById(int id);
	public List<Customer> findAll();
	public void deleteCustomer(int id);
	
}
