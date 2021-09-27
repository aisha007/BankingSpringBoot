package com.p1.example.rest.banking;

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
import com.p1.example.rest.customer.Customer;
import com.p1.example.rest.customer.CustomerController;
import com.p1.example.rest.customer.CustomerRepository;

@RestController
public class BankingController {
	protected Logger logger = Logger.getLogger(BankingController.class
			.getName());
	
//	@Autowired
//	private WebCustomerService service;

	@Autowired
	private BankingRepository repo;
	
	public List<Banking> listAll(){
		return repo.findAll();
	}
	
	public void save(Banking banking){
		repo.save(banking);
	}
	
	public Banking getById(Integer trn_num){
		return repo.findById(trn_num).get();
	}
	
	public void delete(Integer trn_num){
		repo.deleteById(trn_num);
	}
	
	@GetMapping("/displayBanking")
	public String list(){
		Gson gson = new Gson();
		 
		 String jsonList = gson.toJson(listAll());
		return jsonList;
	}
	
	@GetMapping("banking/{trn_num}")
	public ResponseEntity<Banking> get(@PathVariable Integer trn_num){
		try{
			Banking banking = getById(trn_num);
			return new ResponseEntity<Banking>(banking, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<Banking>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/banking")
	public void add(@RequestBody Banking banking){
		save(banking);
	}
	
	@PutMapping("/banking/{trn_num}")
	public ResponseEntity<?> update(@RequestBody Banking banking, @PathVariable Integer trn_num){
		try{
			Banking existBanking = getById(trn_num);
			save(banking);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
