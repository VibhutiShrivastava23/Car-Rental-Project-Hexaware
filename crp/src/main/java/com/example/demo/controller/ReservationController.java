package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/addReservation")
	public String addReservation(@RequestBody Reservation reservation)
	{
		return reservationService.addReservation(reservation);
	}
	
	@PostMapping("/cancelReservation/{resId}")
	public String cancelReservation(@PathVariable int resId)
	{
		return reservationService.cancelReservation(resId);
		
	}
	
	@GetMapping("/rentalHistory/{userId}")
	public List<Reservation> getRentalHistory(@PathVariable int userId)
	{
		return reservationService.getRentalHistory(userId);
	}
	
	@GetMapping("/showByUserId/{UserId}")
	public List<Reservation> showByResId(@PathVariable int UserId)
	{
		return reservationService.showByUserId(UserId);
		
	}
	
}
