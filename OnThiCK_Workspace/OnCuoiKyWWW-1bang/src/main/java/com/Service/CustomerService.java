package com.Service;

import java.util.List;

import com.entity.Customer;

public interface CustomerService {
	public void saveCustomer(Customer customer);

	public Customer findCustomerById(int id);

	public List<Customer> findAll();

	public void deleteCustomer(int id);
}
