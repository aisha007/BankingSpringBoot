package com.p1.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class WebServer {
	public static final String CUSTOMER_SERVICE_URL = "http://customer-service";
	public static final String BANKING_SERVICE_URL = "http://banking-service";
	public static final String ACCOUNTS_SERVICE_URL = "http://accounts-service";
	public static final String ACCOUNT_SERVICE_URL = "http://account-service";

	//public static final String SUBTRACTION_SERVICE_URL = "http://subtraction-service";

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public WebCustomerService CustomerService() {
		return new WebCustomerService(CUSTOMER_SERVICE_URL);
	}

	@Bean
	public BankAppController CustomerController() {
		return new BankAppController(CustomerService(), BankingService(),AccountsService(),AccountService()); // , accountsService());
	}

	@Bean
	public WebBankingService BankingService() {
		return new WebBankingService(BANKING_SERVICE_URL);
	}
	
	@Bean
	public WebAccountsService AccountsService() {
		return new WebAccountsService(ACCOUNTS_SERVICE_URL);
	}
	
	@Bean
	public WebAccountService AccountService() {
		return new WebAccountService(ACCOUNT_SERVICE_URL);
	}
	
	

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
}
