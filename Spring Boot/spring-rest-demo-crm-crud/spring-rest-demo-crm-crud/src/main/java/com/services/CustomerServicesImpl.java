package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controller.CustomerNotFoundException;
import com.dao.CustomerDAO;
import com.entity.Customer;

@Service
public class CustomerServicesImpl implements CustomerServices{
	@Autowired
	private CustomerDAO customerDAO;
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}
	@Transactional
	@Override
	public Customer getCustomers(int id) {
		Customer customer=customerDAO.getCustomers(id);
		if(customer==null) {
			throw new CustomerNotFoundException("Not found Customer by id = "+id);
		}
		return customerDAO.getCustomers(id);
	}
	@Transactional
	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerDAO.addCustomer(customer);
	}
	@Transactional
	@Override
	public Customer updateCustomer(int id, Customer customer) {
		
		return customerDAO.updateCustomer(id, customer);
	}

	@Override
	public void deleteCustomer(int id) {
		Customer customer=customerDAO.getCustomers(id);
		if(customer==null) {
			throw new CustomerNotFoundException("Not found Customer by id = "+id);
		}
		customerDAO.deleteCustomer(id);
		
	}
	
}
