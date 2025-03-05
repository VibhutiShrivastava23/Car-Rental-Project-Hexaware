package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

	List<Car> searchByCategory(String category);

	List<Car> searchByAvailability(String availability);

//	List<Car> findByLocationIgnoreCaseAndCategoryIgnoreCaseAndFuelTypeIgnoreCase(
//		    String location, String category, String fuelType);

	List<Car> findByLocation(String location);

	List<Car> findByLocationAndCategory(String location, String category);

	List<Car> findByLocationAndCategoryAndFuelType(String location, String category, String fuelType);

	
}
