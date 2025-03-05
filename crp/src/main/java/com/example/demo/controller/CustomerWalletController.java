package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerWallet;
import com.example.demo.service.CustomerWalletService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerWalletController {

	@Autowired
	private CustomerWalletService custWalService;
	
	@GetMapping(value="/checkBalance/{userId}")
	public List<CustomerWallet> checkWalBalance(@PathVariable int userId){
		return custWalService.checkWalBalance(userId); 
	}
}
