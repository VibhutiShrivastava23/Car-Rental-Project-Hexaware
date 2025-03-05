package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RefundService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RefundController {

	@Autowired
    private RefundService refundService;

    @GetMapping(value="/checkRefundStatus/{refundId}")
    public String checkRefundStatus(@PathVariable int refundId) {
        return refundService.checkRefundStatus(refundId);
    }
}
