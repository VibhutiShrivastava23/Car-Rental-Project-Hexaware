package com.example.demo.service;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Reservation;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.repo.ReservationRepository;
import com.example.demo.repo.ReviewRepository;
import com.example.demo.repo.UserRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewRepo;
	
	 @Autowired
	 private ReservationRepository reservationRepo;
	 
    @Autowired
    private UserRepository userRepo;
	public void addReview(Review review) 
	{
		reviewRepo.save(review);
	}
	
//	public List<String> ShowReviewForCar (int carId)
//	{
//		List<Integer> userIds = reservationRepo.findByCarId(carId).stream()
//		                                               .map(Reservation::getUserId)
//		                                               .collect(Collectors.toList());
//
//		        if (userIds.isEmpty()) return Collections.emptyList();
//
//		        return reviewRepo.findByUserIdIn(userIds).stream()
//		                         .map(review -> {
//		                             User user = userRepo.findById(review.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
//		                             return user.getFirstName() + " - Rating: " + review.getRating() + " - " + review.getReview();
//		                         })
//		                         .collect(Collectors.toList());
//		    }
	    
	
	
	public void deleteReview(int revId)
	{
		reviewRepo.deleteById(revId);		
	}

}
