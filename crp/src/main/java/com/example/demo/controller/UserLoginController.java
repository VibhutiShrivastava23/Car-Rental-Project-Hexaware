package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserLoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	
	@GetMapping(value="/resetPassword/{email}/{password}")
	public String resetPassword (@PathVariable String email,@PathVariable String password)
	{
		return userLoginService.resetPassword(email, password);
	}
	
	 @GetMapping(value = "/login/{email}/{password}")
	    public int login(@PathVariable String email, @PathVariable String password) 
	 {
	        return userLoginService.login(email, password);
	    }
	 
	 @GetMapping(value="/getUserId/{email}")
	 public int getUserId(@PathVariable String email)
	 {
		 return userLoginService.getUserId(email);
	 }
}
