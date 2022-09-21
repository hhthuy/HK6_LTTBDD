package com.dao;

import java.util.List;

import com.entity.Customer;


public interface CustomerDAO {

	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public Customer findCustomerById(int id);
	public List<Customer> findAll();
	public void deleteCustomer(int id);
}
