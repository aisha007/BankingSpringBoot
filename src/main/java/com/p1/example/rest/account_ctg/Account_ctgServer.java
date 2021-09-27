package com.p1.example.rest.account_ctg;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class Account_ctgServer {
	protected Logger logger = Logger.getLogger(Account_ctgServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "account_ctg-server");

		SpringApplication.run(Account_ctgServer.class, args);
}
}
