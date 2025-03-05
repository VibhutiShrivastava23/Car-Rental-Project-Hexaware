package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Car;
import com.example.demo.repo.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepo;
	
	
	public List<Car> showCars()
	{
		return carRepo.findAll();
	}
	
	public List<Car> searchByCategory(String category)
	{
		return carRepo.searchByCategory(category);
	}
	
	public List<Car> searchByAvailability(String Availability)
	{
		return carRepo.searchByAvailability(Availability);
	}
	
	public List<Car> searchCars(String location , String category , String fuelType) {
		
	    return carRepo.findByLocationAndCategoryAndFuelType(location, category , fuelType);
	}

}
