package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping(value="/addReview")  
	public void addReview(@RequestBody Review review)
	{
		reviewService.addReview(review);
		
	}
	
//	@GetMapping(value="/showReview/{carId}")
//	public List<String> showReviewForCars(@PathVariable int carId)
//	{
//		return reviewService.ShowReviewForCar(carId);
//	}
	
	@DeleteMapping(value="/deleteReview/{revId}")  //admin
	public void deleteReview(@PathVariable int revId)
	{
		reviewService.deleteReview(revId);
	}
	
}
