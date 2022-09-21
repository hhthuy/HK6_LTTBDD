package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.exception.CustomerNotFoundException;
import com.services.CustomerServices;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerServices customerServices;

	@GetMapping("/customers")
	public List<Customer> getCustomer() {
		return customerServices.getCustomers();
	}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer=customerServices.getCustomers(customerId);
		return customer;
	}
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerServices.addCustomer(customer);
	}
	@PutMapping("/customers/{customerId}")
	public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
		return customerServices.updateCustomer(customerId, customer);
	}
	@DeleteMapping("/customers/{customerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable int customerId) {
		 customerServices.deleteCustomer(customerId);
	}
	@GetMapping("/customers/{customerId}/{lastName}")
	public String getInf(@PathVariable int customerId,@PathVariable String lastName) {
		return "Customer = "+customerId+" lastName ="+lastName;
	}
}
