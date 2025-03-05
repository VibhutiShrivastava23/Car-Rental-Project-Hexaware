package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Payment;
import com.example.demo.model.Reservation;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	List<Payment> findByResId(int resId);
	List<Payment> findByPayId(int payId);
	List<Payment> findByUserId(int userId);
	Optional<Payment> findByResIdAndPaymentPurpose(int resId, String paymentPurpose);
	List<Payment> findByUserIdAndStatus(int userId, String string);
	

}
