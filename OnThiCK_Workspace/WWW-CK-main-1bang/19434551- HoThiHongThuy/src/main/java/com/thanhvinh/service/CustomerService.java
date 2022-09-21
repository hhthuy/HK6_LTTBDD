package com.thanhvinh.service;

import java.util.List;

import com.thanhvinh.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer cus);
	public Customer getCustomerById(int id);
	public void deleteCustomer(int id);
}
