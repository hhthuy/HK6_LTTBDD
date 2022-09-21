package com.se.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.Customer;
import com.se.spring.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	//autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET /custoners/
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	// add mapping for GET /customers/(customerId)
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);
		if (theCustomer == null) {
			throw new CustomerNotFoundException(" Customer id not found-" + customerId);

		}
		return theCustomer;

	}

	// add mapping for POST /custgrers-add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	// add mapping for PUT /customers - update existing custoer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	// add mapping for DELETE /customers/{customerId) - delete custoner
	@DeleteMapping("/customers/{customerId}")
	public String deteleCustomer(@PathVariable int customerId) {
		Customer tempCustomer = customerService.getCustomer(customerId);
		if (tempCustomer == null) {
			throw new CustomerNotFoundException(" Customer id not found-" + customerId);

		}
		customerService.deleteCustomer(customerId);
		return "Deleted customer id - " + customerId;

	}

	// test multiple path variables
	@GetMapping("customers/{customerId}/money/{money}")
	public String getCustomermoney(@PathVariable int customerId,@PathVariable String money) {
	
	return "Customer id - "+ customerId + "money"+money;

}

}
