package com.p1.example.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.p1.example.rest.customer.Customer;
import com.p1.example.rest.customer.CustomerRepository;



@Transactional
@Service
public class WebCustomerService {
	
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	
//	@Autowired
//	@LoadBalanced
//	private CustomerRepository repo;
	protected String serviceUrl;
	
	public WebCustomerService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public String displayAll() {
		return restTemplate.getForObject(serviceUrl + "/displayAll", String.class);
		
	}
	public String validate(String custid, String password) {
		return restTemplate.getForObject(serviceUrl + "/validate?customerId={custid}&password={password}", String.class, custid, password); //Add parameters or use post method
	}
	
}
