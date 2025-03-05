package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerWallet;
import com.example.demo.repo.CustomerWalletRepository;

@Service
public class CustomerWalletService {

    @Autowired
    private CustomerWalletRepository walletRepo;

    public List<CustomerWallet> checkWalBalance(int userId) {
        List<CustomerWallet> custWalList = walletRepo.findByUserId(userId);

        if (custWalList.isEmpty()) {
            throw new RuntimeException("User Wallet not found");
        }
        return custWalList;
    }

}
