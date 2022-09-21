package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.CustomerService;
import com.entity.Customer;

@RestController
@RequestMapping("/api")
public class RestCustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("")
	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.findCustomerById(id);
	}

	@PostMapping("")
	public void saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}

	// -- update
	@PutMapping("")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
	}
}
