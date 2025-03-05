package com.example.demo.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.demo.model.Car;
import com.example.demo.model.CustomerWallet;
import com.example.demo.model.Payment;
import com.example.demo.model.Refund;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.repo.CarRepository;
import com.example.demo.repo.CustomerWalletRepository;
import com.example.demo.repo.PaymentRepository;
import com.example.demo.repo.RefundRepository;
import com.example.demo.repo.ReservationRepository;
import com.example.demo.repo.UserRepository;


@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	CarRepository carRepo;
	
	@Autowired
	PaymentRepository payRepo;
	
	@Autowired
	CustomerWalletRepository walletRepo;
	
	@Autowired
	RefundRepository refundRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private JavaMailSender mailSender;

	public long calculateDays(LocalDate startDate, LocalDate endDate) {
		return ChronoUnit.DAYS.between(startDate, endDate);
    }


	public double getCharges(int carId)
	{
		Optional<Car> optCar =carRepo.findById(carId);
			return optCar.get().getPrice();
	}

	public String addReservation(Reservation reservation) {
	    Car car = carRepo.findById(reservation.getCarId()).orElseThrow(() -> new RuntimeException("Care ID not found"));

	    if (!"available".equalsIgnoreCase(car.getAvailability())) {
	        return "Car is not available for selected dates";
	    }

	    long days = (calculateDays(reservation.getPickupDate(), reservation.getDropDate())) + 1;
	    double totalCost = days * getCharges(reservation.getCarId());
	    reservation.setTotalCost(totalCost);

	    double advanceAmount = totalCost * 0.30;
	    reservation.setAdvanceAmount(advanceAmount);
	    reservation.setStatus("pending");

	    reservationRepo.save(reservation);

	    createPaymentRecord(reservation,advanceAmount,"advance");
	    createPaymentRecord(reservation, totalCost - advanceAmount, "balance");
//	    Payment pay1 = new Payment();
//	    pay1.setUserId(reservation.getUserId());
//	    pay1.setResId(reservation.getResId());
//	    pay1.setAmount(advanceAmount);
//	    pay1.setPaymentPurpose("advance");
//	    pay1.setStatus("pending"); 
//	    pay1.setPaymentMethod("none");
//	    payRepo.save(pay1);
//
//	    Payment pay2 = new Payment();
//	    pay2.setUserId(reservation.getUserId());
//	    pay2.setResId(reservation.getResId());
//	    pay2.setAmount(totalCost - advanceAmount);
//	    pay2.setPaymentPurpose("balance");
//	    pay2.setStatus("pending"); 
//	    pay2.setPaymentMethod("none");
//	    payRepo.save(pay2);
	    return "Reservation created successfully. Please make the advance payment to confirm reservation";
	}
	
	private void createPaymentRecord(Reservation reservation, double amount, String paymentPurpose) {
	    Payment payment = new Payment();
	    payment.setUserId(reservation.getUserId());
	    payment.setResId(reservation.getResId());
	    payment.setAmount(amount);
	    payment.setPaymentPurpose(paymentPurpose);
	    payment.setStatus("pending");
	    payment.setPaymentMethod("none");
	    payRepo.save(payment);
	}

	

	
	public String cancelReservation(int resId)
	{
		Reservation reservation = reservationRepo.findById(resId).orElseThrow(() -> new RuntimeException("Reservation Not found"));
		
		if ("cancelled".equalsIgnoreCase(reservation.getStatus())) {
	        return "Reservation has already been cancelled.";
	    }
		
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime pickupDateTime = reservation.getPickupDate().atTime(reservation.getPickupTime());
		
		long Timediff = Duration.between(currentTime, pickupDateTime).toHours();
		if(Timediff < 2)
		{
			return "Reservation cannot be cancelled as it is less than 2 hours before the pickup time.";
		}
		
		 Payment advancePay = payRepo.findByResIdAndPaymentPurpose(resId, "advance").orElseThrow(() -> new RuntimeException("Advance payment not found"));
		 
		 double refundAmount = 0;
		 if("paid".equalsIgnoreCase(advancePay.getStatus()))
		 {
			refundAmount = advancePay.getAmount() * 0.80;
		 }
		 
		 CustomerWallet wallet = walletRepo.findByUserIdAndWalType(reservation.getUserId(),advancePay.getPaymentMethod()).orElseThrow(() -> new RuntimeException("Customer wallet not found"));
		 
		 wallet.setWalamount(wallet.getWalamount() + refundAmount);
		 walletRepo.save(wallet);
		 
		 
		 Refund refund = new Refund();
		 refund.setUserId(advancePay.getUserId());
		 refund.setPayId(advancePay.getPayId());
		 refund.setRefundAmount(refundAmount);
		 refund.setRefundMethod(wallet.getWalType());
		 refund.setRefundStatus("Processed");
		 refundRepo.save(refund);
		 
		 advancePay.setStatus("refunded");
		 payRepo.save(advancePay);
		 
		 Payment balancePay = payRepo.findByResIdAndPaymentPurpose(resId, "balance").orElseThrow(() -> new RuntimeException("Balance payment not found"));
		    
		    if ("pending".equalsIgnoreCase(balancePay.getStatus())) {
		        balancePay.setStatus("canceled"); 
		        payRepo.save(balancePay);
		    }
		 
		 reservation.setStatus("cancelled");
		 reservationRepo.save(reservation);
		 
		 Car car = carRepo.findById(reservation.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
		 car.setAvailability("available");
		 carRepo.save(car);
		 
		 sendCancellationEmail(reservation);

		 return "Reservation cancelled successfully. 80% of the paid amount is refunded to your wallet: " + wallet.getWalType();
	}
	
	public void sendCancellationEmail(Reservation reservation)
	{
		User user = userRepo.findById(reservation.getUserId())
	            .orElseThrow(() -> new RuntimeException("User not found"));
		String customerEmail = user.getEmail();
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(customerEmail);
		message.setSubject("Reservation Cancellation Confirmation");
		message.setText("Dear " + user.getFirstName() + ",\n\n"
			    + "We have successfully processed your request to cancel your reservation (ID: " + reservation.getResId() + ") " 
			    + ".\n"
			    + "		As per our policy, 80% of the paid amount will be refunded to your wallet within the next 24 hours.\n\n"
			    + "If you have any questions or need further assistance, feel free to contact our support team.\n\n"
			    + "Thank you for choosing CRP Team. We hope to serve you again in the future.\n\n\n\n\n\n"
			    + "Best regards,\n"
			    + "The CRP Team");
		
		mailSender.send(message);
	}
	

//	public List<Reservation> showReservation()
//	{
//		return reservationRepo.findAll();
//	}
	
	public List<Reservation> getRentalHistory(int userId) {
        return reservationRepo.findByUserId(userId);
    }
	
	public List<Reservation> showByUserId(int userId)
	{
		return reservationRepo.findByUserId(userId);
		
	}
	
	


}
