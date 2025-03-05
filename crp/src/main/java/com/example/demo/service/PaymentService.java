package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.model.CustomerWallet;
import com.example.demo.model.Payment;
import com.example.demo.model.Reservation;
import com.example.demo.repo.CarRepository;
import com.example.demo.repo.CustomerWalletRepository;
import com.example.demo.repo.PaymentRepository;
import com.example.demo.repo.ReservationRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository payRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private CustomerWalletRepository walletRepo;
	
	public List<Payment> searchByResId(int resId)
	{
		return payRepo.findByResId(resId);
	}
	
	public List<Payment> showPaidPayments(int userId) {
		return payRepo.findByUserIdAndStatus(userId, "paid");
	}
	
	public List<Payment> showPendingPayments(int userId) {
		return payRepo.findByUserIdAndStatus(userId, "pending");
	}


	
//	public List<Payment> showByPayId(int payId)
//	{
//		return payRepo.findByPayId(payId);
//		
//	}
	
	public String AdvancePayment(int resId, String paymentMethod) {
	    Reservation reservation = reservationRepo.findById(resId)
	            .orElseThrow(() -> new RuntimeException("Reservation ID not found"));

	    Payment advancePayment = payRepo.findByResIdAndPaymentPurpose(resId, "advance")
	            .orElseThrow(() -> new RuntimeException("Advance payment entry not found")); 
	    
	    if ("paid".equalsIgnoreCase(advancePayment.getStatus())) {
            return "Advance payment has already been made for this reservation.";
        }

	    double advanceAmount = advancePayment.getAmount();
	    int userId = reservation.getUserId();

	    CustomerWallet wallet = walletRepo.findByUserIdAndWalType(userId, paymentMethod)
	            .orElseThrow(() -> new RuntimeException("Wallet with the selected payment method not found"));

	    double walletBalance = wallet.getWalamount();

	    if (walletBalance < advanceAmount) {
	        return "Insufficient balance in wallet. Please choose another payment method";
	    }

	    wallet.setWalamount(walletBalance - advanceAmount);
	    walletRepo.save(wallet);

	    advancePayment.setStatus("paid");
	    advancePayment.setPaymentMethod(paymentMethod);
	    payRepo.save(advancePayment);

	    reservation.setStatus("confirmed");
	    reservationRepo.save(reservation);

	    Car car = carRepo.findById(reservation.getCarId()).get();
	    car.setAvailability("Reserved");
	    carRepo.save(car);

	    return "Advance payment successful and reservation is confirmed";
	}
	
	public String finalPayment(int resId, String paymentMethod) {
	    Reservation reservation = reservationRepo.findById(resId)
	            .orElseThrow(() -> new RuntimeException("Reservation ID not found"));

	    Payment finalPayment = payRepo.findByResIdAndPaymentPurpose(resId, "balance")
	            .orElseThrow(() -> new RuntimeException("balance payment entry not found")); 
	    
	    if ("paid".equalsIgnoreCase(finalPayment.getStatus())) {
            return "Final payment has already been made for this reservation.";
        }

	    double finalAmount = finalPayment.getAmount();
	    int userId = reservation.getUserId();

	    CustomerWallet wallet = walletRepo.findByUserIdAndWalType(userId, paymentMethod)
	            .orElseThrow(() -> new RuntimeException("Wallet with the selected payment method not found"));

	    double walletBalance = wallet.getWalamount();

	    if (walletBalance < finalAmount) {
	        return "Insufficient balance in wallet. Please choose another payment method";
	    }

	    wallet.setWalamount(walletBalance - finalAmount);
	    walletRepo.save(wallet);

	    finalPayment.setStatus("paid");
	    finalPayment.setPaymentMethod(paymentMethod);
	    payRepo.save(finalPayment);

	    reservation.setStatus("completed");
        reservationRepo.save(reservation);

	    Car car = carRepo.findById(reservation.getCarId()).get();
	    car.setAvailability("available");
	    carRepo.save(car);

	    return "Final payment successful";
	}
	
	public List<Payment> getPaymentHistoryByUserId(int userId)
	{
		return payRepo.findByUserId(userId);
	}
	
	public String checkPaymentStatus(int resId)
	{
		List<Payment> payment = payRepo.findByResId(resId);
		
		if(payment.isEmpty())
		{
			return "No payments found for this Reservation";
		}
		
		 boolean advancePaid = payment.stream().anyMatch(x -> "advance".equals(x.getPaymentPurpose()) && "paid".equals(x.getStatus()));
		 boolean balancePaid = payment.stream().anyMatch(x -> "balance".equals(x.getPaymentPurpose()) && "paid".equals(x.getStatus()));

		if(advancePaid && balancePaid)
		{
			return "Full Payment Completed";
		}
		else if(advancePaid)
		{
			return "Advance Paid , balance pending";
		}
		else
		{
			return "No advance payment made";
		}
	}

	
}
