package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerWallet;
import com.example.demo.model.Reservation;

@Repository
public interface CustomerWalletRepository extends JpaRepository<CustomerWallet, Integer>{

	Optional<CustomerWallet> findByUserIdAndWalType(int userId, String paymentMethod);
	List<CustomerWallet> findByUserId(int userId);
	
}
