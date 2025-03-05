package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CARID")
	private int carId;
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	@Column(name="YEAR")
	private int year;
	@Column(name="LOCATION")
	private String location;
	@Column(name="FASTAG")
	private String fastag;
	@Column(name="PRICE")
	private double price;
	@Column(name="AVAILABILITY")
	private String availability;
	@Column(name="CATEGORY")
	private String category;
	@Column(name="FUELTYPE")
	private String fuelType;
	@Column(name="GEARTYPE")
	private String gearType;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFastag() {
		return fastag;
	}
	public void setFastag(String fastag) {
		this.fastag = fastag;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getGearType() {
		return gearType;
	}
	public void setGearType(String gearType) {
		this.gearType = gearType;
	}
	public Car(int carId, String make, String model, int year, String location, String fastag, double price,
			String availability, String category, String fuelType, String gearType) {
		
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.location = location;
		this.fastag = fastag;
		this.price = price;
		this.availability = availability;
		this.category = category;
		this.fuelType = fuelType;
		this.gearType = gearType;
	}
	public Car() {
		
		// TODO Auto-generated constructor stub
	}
	

}
