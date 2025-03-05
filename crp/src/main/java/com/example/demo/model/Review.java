package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Review")
public class Review {
	
	@Id
	@Column(name="REVID")
	private int revId;
	@Column(name="USERID")
	private int userId;
	@Column(name="RATING")
	private int rating;
	@Column(name="REVIEW")
	private String review;
	public int getRevId() {
		return revId;
	}
	public void setRevId(int revId) {
		this.revId = revId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Review() {
	
		// TODO Auto-generated constructor stub
	}
	public Review(int revId, int userId, int rating, String review) {
		
		this.revId = revId;
		this.userId = userId;
		this.rating = rating;
		this.review = review;
	}
	
	
	

}
