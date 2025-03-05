package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;
import com.example.demo.service.ReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value="/showPaidPayments/{userId}")
	public List<Payment> showPaidPayments(@PathVariable int userId) {
		return paymentService.showPaidPayments(userId);
	}
	
	@GetMapping(value="/showPendingPayments/{userId}")
	public List<Payment> showPendingPayments(@PathVariable int userId) {
		return paymentService.showPendingPayments(userId);
	}
	
	
	@PostMapping(value="/advancePayment/{resId}/{paymentMethod}")
	public String advancePayment(
	        @PathVariable int resId,
	        @PathVariable String paymentMethod) {
	    return paymentService.AdvancePayment(resId, paymentMethod);
	}

	@PostMapping(value="/finalPayment/{resId}/{paymentMethod}")
	public String finalPayment(
	        @PathVariable int resId,
	        @PathVariable String paymentMethod) {
	    return paymentService.finalPayment(resId, paymentMethod);
	}
	

//	public List<Payment> showByPayId(@PathVariable int payId)
//	{
//		return paymentService.showByPayId(payId);
//	}
	
	@GetMapping(value="/searchByResId/{resId}")
	public List<Payment> searchByResId(@PathVariable int resId)
	{
		return paymentService.searchByResId(resId);
	}
	
	@GetMapping(value="/getPaymentHistory/{userId}")
	public List<Payment> getPaymentHistoryByUserId(@PathVariable int userId)
	{
		return paymentService.getPaymentHistoryByUserId(userId);
	}
	
	@GetMapping(value="/checkPaymentStatus/{resId}")
	public String checkPaymentStatus(@PathVariable int resId)
	{
		return paymentService.checkPaymentStatus(resId);
	}
}
