package com.p1.example.rest.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.example.rest.banking.Banking;




//This is an interface which extends 
//JpaRepository from the springframework
//You can have first <Integer, Product>

//ProductRepository interface is a marker interface 
//whereas JpaRepository is not an marker interface, it is a class. 
public interface AccountRepository extends JpaRepository<Account, Integer>
{
	
}
