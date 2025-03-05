package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Refund;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Integer> {

}
