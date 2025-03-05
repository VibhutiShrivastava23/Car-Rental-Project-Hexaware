package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Refund;
import com.example.demo.repo.RefundRepository;

@Service
public class RefundService {
	
	@Autowired
	private RefundRepository refundRepo;
	
	public String checkRefundStatus(int refundId) {
	    Refund refund = refundRepo.findById(refundId).orElseThrow(() -> new RuntimeException("Refund ID not found"));

	    return refund.getRefundStatus();
	}


}
