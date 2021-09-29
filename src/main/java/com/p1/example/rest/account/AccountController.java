package com.p1.example.rest.account;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
//import com.p1.example.rest.banking.Banking;
//import com.p1.example.rest.banking.BankingController;
//import com.p1.example.rest.banking.BankingRepository;

@RestController
public class AccountController {
	protected Logger logger = Logger.getLogger(AccountController.class
			.getName());
	
//	@Autowired
//	private WebCustomerService service;

	@Autowired
	private AccountRepository repo;
	
	public List<Account> listAll(){
		return repo.findAll();
	}
	
	public void save(Account accounts){
		repo.save(accounts);
	}
	
//	public Account getById(Integer acctype){
//		return repo.findById(acctype).get();
//	}
	
//	public void delete(Str acct_num){
//		repo.deleteById(acct_num);
//	}
	
	@GetMapping("/displayAccount")
	public String list(){
		Gson gson = new Gson();
		 
		 String jsonList = gson.toJson(listAll());
		return jsonList;
	}
	
//	@GetMapping("account/{acct_num}")
//	public ResponseEntity<Account> get(@PathVariable Integer acct_num){
//		try{
//			Account accounts = getById(acct_num);
//			return new ResponseEntity<Account>(accounts, HttpStatus.OK);
//		}catch(NoSuchElementException e){
//			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	@PostMapping("/account")
	public void add(@RequestBody Account accounts){
		save(accounts);
	}
	
//	@PutMapping("/accounts/{acct_num}")
//	public ResponseEntity<?> update(@RequestBody Account accounts, @PathVariable Integer acct_num){
//		try{
//			Account existAccounts = getById(acct_num);
//			save(accounts);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}catch(NoSuchElementException e){
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
}
