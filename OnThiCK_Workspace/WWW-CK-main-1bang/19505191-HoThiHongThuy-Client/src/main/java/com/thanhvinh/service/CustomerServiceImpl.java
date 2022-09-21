package com.thanhvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thanhvinh.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	private RestTemplate restTemplate;
	private String crmRestUrl;
	
	@Autowired
	public CustomerServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String url) {
		restTemplate = theRestTemplate;
		crmRestUrl = url;
	}
	
	@Override
	public List<Customer> getCustomers() {		
		ResponseEntity<List<Customer>> responseEntity = 
				restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Customer>>() {}); 
		List<Customer> customers = responseEntity.getBody();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer cus) {		
		int id = cus.getId();
		if(id == 0) {
			restTemplate.postForEntity(crmRestUrl, cus, String.class);
		}else {
			restTemplate.put(crmRestUrl, cus);
		}
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer theCustomer = restTemplate.getForObject(crmRestUrl + "/" + id, Customer.class);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {		
		restTemplate.delete(crmRestUrl + "/" + id);		
	}

}
