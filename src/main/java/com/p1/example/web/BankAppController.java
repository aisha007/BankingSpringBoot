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

	@Autowired
	protected WebAccountsService accountsService;
	
	@Autowired
	protected WebAccountService accountService;

	protected Logger logger = Logger.getLogger(BankAppController.class
			.getName());

	// initialize all packages
	public BankAppController(WebCustomerService customerService, WebBankingService bankingService,
			WebAccountsService accountsService, WebAccountService accountService) {
		this.customerService = customerService;
		this.bankingService = bankingService; 
		this.accountsService = accountsService;
		this.accountService = accountService;
		
	}

	@RequestMapping("/displayAccount")
	public String doDisplayAccountCtg(Model model) {

//		String sum = customerService.add(addend1, addend2);
		String account = accountService.displayAll(); 
		logger.info("Account Data: " +account );
		model.addAttribute("json", account );

		return "account";
	}
	
	@RequestMapping("/displayAccounts")
	public String doDisplayAccounts(Model model) {

//		String sum = customerService.add(addend1, addend2);
		String accounts = accountsService.displayAll(); 
		logger.info("Account Details: " +accounts );
		model.addAttribute("json", accounts );

		return "accounts";
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

		return "customers";
	}

	
}
