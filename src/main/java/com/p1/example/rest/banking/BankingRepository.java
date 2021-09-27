package com.p1.example.rest.banking;

import org.springframework.data.jpa.repository.JpaRepository;

 


// This is an interface which extends 
// JpaRepository from the springframework
// You can have first <Integer, Product>

// ProductRepository interface is a marker interface 
//whereas JpaRepository is not an marker interface, it is a class. 
public interface BankingRepository extends JpaRepository<Banking, Integer>
{
	
}
