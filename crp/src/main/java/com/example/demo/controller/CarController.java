package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {
	
	@Autowired
	CarService carService;
	
	@GetMapping(value="/showCar")
	public List<Car> showCars()
	{
		return carService.showCars();
	}
	
	@GetMapping(value="/searchByCategory/{category}")
	public List<Car> searchByCategory(@PathVariable String category)
	{
		return carService.searchByCategory(category);
	}
	
	@GetMapping(value="/searchByAvailability/{availability}")
	public List<Car> searchByAvailability(@PathVariable String availability)
	{
		return carService.searchByAvailability(availability);
	}
	
	@GetMapping(value="/searchCars/{location}/{category}/{fuelType}")
	public List<Car> searchCars(
	        @PathVariable String location,
	        @PathVariable String category,
	        @PathVariable String fuelType) {
	    return carService.searchCars(location , category , fuelType);
	}
	

}
