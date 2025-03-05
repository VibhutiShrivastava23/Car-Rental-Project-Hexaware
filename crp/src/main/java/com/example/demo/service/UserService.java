package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.repo.PaymentRepository;
import com.example.demo.repo.ReservationRepository;
import com.example.demo.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PaymentRepository payRepo;
	
	

	public void addUser(User user) {
		userRepo.save(user);
	}
	
	public void updateUser( User user)
	{
		userRepo.save(user);
	}
	
	 public User showUserById(int userId) {
	        return userRepo.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
	    }
	 
	 public User searchByUserName(String firstName)
	 {
		return userRepo.findByFirstName(firstName);
		 
	 }
	 
	 public String deactivateUserAccount(int userId)
	 {
		 User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		 
		 user.setState("deactivated");
		 userRepo.save(user);
		 
		 return "Account deactivated";
	 }
	 
	 
	
}
