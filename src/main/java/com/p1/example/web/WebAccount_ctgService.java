package com.p1.example.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Transactional
@Service
public class WebAccount_ctgService {
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	
//	@Autowired
//	@LoadBalanced
//	private CustomerRepository repo;
	protected String serviceUrl;
	
	public WebAccount_ctgService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public String displayAll() {
		return restTemplate.getForObject(serviceUrl + "/displayAccount_ctg", String.class);
		
	}
	

}
