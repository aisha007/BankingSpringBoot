package com.p1.example.rest.banking;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class BankingServer {
	protected Logger logger = Logger.getLogger(BankingServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "banking-server");

		SpringApplication.run(BankingServer.class, args);
}
}
