package com.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Service.CustomerService;
import com.entity.Customer;

@RestController
@RequestMapping("/api")
public class RestCustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path = "" ,method = RequestMethod.GET)
	public List<Customer> getCustomers() {
		return customerService.findAll();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.findCustomerById(id);
	}
	
	@RequestMapping(path = "" , method = RequestMethod.POST)
	public void saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}
	
	@RequestMapping(path = "/{id}" ,method = {RequestMethod.POST, RequestMethod.DELETE})
	public void deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
	}
}
