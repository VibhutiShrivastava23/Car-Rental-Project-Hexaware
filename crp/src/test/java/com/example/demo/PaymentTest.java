package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Payment;

class PaymentTest {

private Payment payment;
	
	@BeforeEach
	public void setUp() {
		payment = new Payment(1, 1, 1, 4000.0, "Gpay", "paid", "advance");
	}
	
	@Test
	public void testGettersAndSetters() {
	
		payment.setPayId(2);
		payment.setUserId(2);
		payment.setResId(2);
		payment.setAmount(2000.0);
		payment.setPaymentMethod("Debit Card");
		payment.setStatus("paid");
		payment.setPaymentPurpose("advance");
		
		assertEquals(2, payment.getPayId());
		assertEquals(2, payment.getUserId());
		assertEquals(2, payment.getResId());
		assertEquals(2000.0, payment.getAmount());
		assertEquals("Debit Card", payment.getPaymentMethod());
		assertEquals("paid", payment.getStatus());
		assertEquals("advance", payment.getPaymentPurpose());
	}
	
	@Test
	public void testDefaultConstructor() {
		Payment payment1 = new Payment();
		assertNotNull(payment1); 
	}
	
	@Test
	public void testParameterizedConstructor() {
		
		assertEquals(1, payment.getPayId());
		assertEquals(1, payment.getUserId());
		assertEquals(1, payment.getResId());
		assertEquals(4000.0, payment.getAmount());
		assertEquals("Gpay", payment.getPaymentMethod());
		assertEquals("paid", payment.getStatus());
		assertEquals("advance", payment.getPaymentPurpose());
	}

}
