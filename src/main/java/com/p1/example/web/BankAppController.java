package com.p1.example.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.p1.example.rest.customer.Customer;

@Controller
public class BankAppController {
	@Autowired
	protected WebCustomerService customerService;
	
	@Autowired
	protected WebBankingService bankingService;

	

	protected Logger logger = Logger.getLogger(BankAppController.class
			.getName());

	// initialize all packages
	public BankAppController(WebCustomerService customerService, WebBankingService bankingService) {
		this.customerService = customerService;
		this.bankingService = bankingService; 
		
	}

	@RequestMapping("/displayBanking")
	public String doDisplayBanking(Model model) {

//		String sum = customerService.add(addend1, addend2);
		String banking = bankingService.displayAll(); 
		logger.info("Banking Data: " +banking );
		model.addAttribute("json", banking );

		return "banking";
	}
	
	@RequestMapping("/displayAll")
	public String doDisplayAll(Model model) {

//		String sum = customerService.add(addend1, addend2);
		String customers = customerService.displayAll(); 
		logger.info("Customer Data: " +customers );
		model.addAttribute("json", customers );

		return "banking";
	}

	
}
