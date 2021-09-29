package com.p1.example.rest.account;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class AccountServer {
	protected Logger logger = Logger.getLogger(AccountServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "account-server");

		SpringApplication.run(AccountServer.class, args);
}
}
