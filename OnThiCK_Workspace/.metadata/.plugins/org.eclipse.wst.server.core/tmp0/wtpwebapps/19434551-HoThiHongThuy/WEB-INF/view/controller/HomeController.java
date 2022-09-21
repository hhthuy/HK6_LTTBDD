package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.entity.Customer;


@Controller
@RequestMapping("/")
public class HomeController {
	private final String URL = "http://localhost:8080/19434551-HoThiHongThuy/api";
	
	
	@GetMapping("")
	public String getCustomers(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		Customer[] customers = restTemplate.getForObject(URL, Customer[].class);
		model.addAttribute("customers", customers);//c:forEach
		return "home";
	}

	//add----------------
	@GetMapping("add-customer")
	public String addCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "add-customer-form";
	}

	@PostMapping("add-customer")
	public String addCustomer(Model model, @ModelAttribute("customer") Customer customer) {
		RestTemplate restTemplate = new RestTemplate();
		customer.setId(0);
		restTemplate.postForObject(URL, customer, Customer.class);
		return "redirect:/";
	}
	//update--------------
	@GetMapping("{id}")
	public String updateCustomerForm(Model model, @PathVariable int id) {
		if (id == -1) {
			return "redirect:/";
		}
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(URL + "/" + id, Customer.class);
		model.addAttribute("customer", customer);
		return "update-customer-form";
	}

	@PostMapping("{id}")
	public String updateCustomer(Model model, @ModelAttribute("customer") Customer customer) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL, customer, Customer.class);
		return "redirect:/" + customer.getId();
	}

	//delete-------------
	@GetMapping("/delete/{id}")
	public String deleteCustomer(Model model, @PathVariable int id) {
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = new Customer(id);
		restTemplate.delete(URL + "/" + id, customer, Customer.class);
		return "redirect:/";
	}
}
