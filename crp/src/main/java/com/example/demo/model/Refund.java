package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="REFUND")
public class Refund {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="REFUNDID")
	private int refundId;
	@Column(name="PAYID")
	private int payId;
	@Column(name="USERID")
	private int userId;
	@Column(name="REFUNDAMOUNT")
	private double refundAmount;
	@Column(name="REFUNDMETHOD")
	private String refundMethod;
	@Column(name="REFUNDSTATUS")
	private String refundStatus;
	public int getRefundId() {
		return refundId;
	}
	public void setRefundId(int refundId) {
		this.refundId = refundId;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundMethod() {
		return refundMethod;
	}
	public void setRefundMethod(String refundMethod) {
		this.refundMethod = refundMethod;
	}
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	public Refund(int refundId, int payId, int userId, double refundAmount, String refundMethod, String refundStatus) {
		
		this.refundId = refundId;
		this.payId = payId;
		this.userId = userId;
		this.refundAmount = refundAmount;
		this.refundMethod = refundMethod;
		this.refundStatus = refundStatus;
	}
	public Refund() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	

}
