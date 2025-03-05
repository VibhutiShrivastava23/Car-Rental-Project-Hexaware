package com.example.demo.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RESID")
	private int resId;
    @Column(name="USERID")
    private int userId;
	@Column(name="CARID")
	private int carId;
	@Column(name="PICKUPDATE")
    private LocalDate pickupDate;
    @Column(name="DROPDATE")
    private LocalDate dropDate;
    @Column(name="PICKUPTIME")
    private LocalTime pickupTime;
    @Column(name="DROPTIME")
    private LocalTime dropTime;
    @Column(name="TOTALCOST")
    private Double totalCost;
    @Column(name="ADVANCEAMOUNT")
    private Double advanceAmount;
    @Column(name="STATUS")
    private String status;
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public LocalDate getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}
	public LocalDate getDropDate() {
		return dropDate;
	}
	public void setDropDate(LocalDate dropDate) {
		this.dropDate = dropDate;
	}
	public LocalTime getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(LocalTime pickupTime) {
		this.pickupTime = pickupTime;
	}
	public LocalTime getDropTime() {
		return dropTime;
	}
	public void setDropTime(LocalTime dropTime) {
		this.dropTime = dropTime;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public Double getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(Double advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Reservation(int resId, int userId, int carId, LocalDate pickupDate, LocalDate dropDate, LocalTime pickupTime,
			LocalTime dropTime, Double totalCost, Double advanceAmount, String status) {
		
		this.resId = resId;
		this.userId = userId;
		this.carId = carId;
		this.pickupDate = pickupDate;
		this.dropDate = dropDate;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.totalCost = totalCost;
		this.advanceAmount = advanceAmount;
		this.status = status;
	}
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
    
    
    

}