package com.p1.example.rest.account_ctg;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.p1.example.web.WebAccount_ctgService;
import com.google.gson.Gson;
import com.p1.example.rest.account_ctg.Account_ctg;
//import com.p1.example.rest.banking.BankingController;

@RestController
public class Account_ctgController {
	protected Logger logger = Logger.getLogger(Account_ctgController.class
			.getName());
	@Autowired
	private Account_ctgRepository repo;

	@GetMapping("/accctg")
	public List<Account_ctg> getAccCtg(){
		List<Account_ctg> actg=repo.findAll();
		return actg;
	}
	@GetMapping("/displayAccount_ctg")
	public String list(){
		Gson gson = new Gson();
		 
		 String jsonList = gson.toJson(getAccCtg());
		return jsonList;
	}
}
