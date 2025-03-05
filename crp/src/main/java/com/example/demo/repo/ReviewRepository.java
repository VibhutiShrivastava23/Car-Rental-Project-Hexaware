package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

	//List<Review> findByCarId(int carId);

	//List<Review> findByUserIdIn(List<Integer> userIds);

}
