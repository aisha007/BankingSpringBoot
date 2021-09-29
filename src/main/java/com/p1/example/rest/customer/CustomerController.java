package com.p1.example.rest.customer;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;



@RestController
public class CustomerController {
	protected Logger logger = Logger.getLogger(CustomerController.class
			.getName());
	
//	@Autowired
//	private WebCustomerService service;

	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> listAll(){
		return repo.findAll();
	}
	
	public void save(Customer customer){
		repo.save(customer);
	}
	
	public Customer getById(Integer id){
		return repo.findById(id).get();
	}
	
	public void delete(Integer id){
		repo.deleteById(id);
	}
	
	@GetMapping("/displayAll")
	public String list(){
		Gson gson = new Gson();
		 
		 String jsonList = gson.toJson(listAll());
		return jsonList;
	}
	@GetMapping("/validate")
	public String doValidate(@RequestParam(defaultValue="2") String custid,
			@RequestParam(defaultValue="123") String password){
		int tc_custid = Integer.valueOf(custid);
		Customer c = getById(tc_custid);
		if ((c.getCustid() == tc_custid) && (c.getPassword().equals(password)))
			return "true";
		else
			return "false";
	}
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> get(@PathVariable Integer id){
		try{
			Customer customer = getById(id);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/customers")
	public void add(@RequestBody Customer customer){
		save(customer);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id){
		try{
			Customer existCustomer = getById(id);
			save(customer);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}