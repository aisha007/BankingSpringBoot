package com.p1.example.rest.accounts;

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
public class AccountsController {
	protected Logger logger = Logger.getLogger(AccountsController.class
			.getName());
	
//	@Autowired
//	private WebCustomerService service;

	@Autowired
	private AccountsRepository repo;
	
	public List<Accounts> listAll(){
		return repo.findAll();
	}
	
	public void save(Accounts accounts){
		repo.save(accounts);
	}
	
	public Accounts getById(Integer acct_num){
		return repo.findById(acct_num).get();
	}
	
	public void delete(Integer acct_num){
		repo.deleteById(acct_num);
	}
	
	@GetMapping("/displayAccounts")
	public String list(){
		Gson gson = new Gson();
		 
		 String jsonList = gson.toJson(listAll());
		return jsonList;
	}
	
	@GetMapping("accounts/{acct_num}")
	public ResponseEntity<Accounts> get(@PathVariable Integer acct_num){
		try{
			Accounts accounts = getById(acct_num);
			return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<Accounts>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/accounts")
	public void add(@RequestBody Accounts accounts){
		save(accounts);
	}
	
	@PutMapping("/accounts/{acct_num}")
	public ResponseEntity<?> update(@RequestBody Accounts accounts, @PathVariable Integer acct_num){
		try{
			Accounts existAccounts = getById(acct_num);
			save(accounts);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
