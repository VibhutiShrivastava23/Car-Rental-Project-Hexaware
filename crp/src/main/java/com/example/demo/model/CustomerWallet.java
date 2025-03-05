package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMERWALLET")
public class CustomerWallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WALID")
	private int walId;
	@Column(name="USERID")
	private int userId;
	@Column(name="WALTYPE")
	private String walType;
	@Column(name="WALAMOUNT")
	private double walamount;
	public int getWalId() {
		return walId;
	}
	public void setWalId(int walId) {
		this.walId = walId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getWalType() {
		return walType;
	}
	public void setWalType(String walType) {
		this.walType = walType;
	}
	public double getWalamount() {
		return walamount;
	}
	public void setWalamount(double walamount) {
		this.walamount = walamount;
	}
	public CustomerWallet(int walId, int userId, String walType, double walamount) {
		
		this.walId = walId;
		this.userId = userId;
		this.walType = walType;
		this.walamount = walamount;
	}
	public CustomerWallet() {
		
		// TODO Auto-generated constructor stub
	}
	
	

}
