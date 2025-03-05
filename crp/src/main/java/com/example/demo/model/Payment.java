package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PAYID")
	private int payId;
	@Column(name="USERID")
	private int userId;
	@Column(name="RESID")
	private int resId;
	@Column(name="AMOUNT")
	private Double amount;
	@Column(name="PAYMENTMETHOD")
	private String paymentMethod;
	@Column(name="STATUS")
	private String status = "pending";
	@Column(name="PAYMENTPURPOSE")
	private String paymentPurpose;
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
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentPurpose() {
		return paymentPurpose;
	}
	public void setPaymentPurpose(String paymentPurpose) {
		this.paymentPurpose = paymentPurpose;
	}
	public Payment(int payId, int userId, int resId, Double amount, String paymentMethod, String status,
			String paymentPurpose) {
		
		this.payId = payId;
		this.userId = userId;
		this.resId = resId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.paymentPurpose = paymentPurpose;
	}
	public Payment() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	

}
