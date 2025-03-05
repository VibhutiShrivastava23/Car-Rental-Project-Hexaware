package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/addUser")
	public void addUser(@RequestBody User user)
	{
		userService.addUser(user);
	}
	
	@PutMapping(value="/updateUserDetails")
	public void updateUser(@RequestBody User user)
	{
		userService.updateUser(user);
	}
	
	@GetMapping(value="/searchByName/{firstName}")
	 public User searchByUserName(@PathVariable String firstName) {
		 return userService.searchByUserName(firstName);
	 }
	
	@GetMapping(value="/deactivateAccount/{userId}")
	public String deactivateUserAccount(@PathVariable int userId) {
		return userService.deactivateUserAccount(userId);
	}
	

}
