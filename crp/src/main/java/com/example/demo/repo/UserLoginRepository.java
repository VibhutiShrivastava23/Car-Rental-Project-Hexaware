package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer>{

	Optional<UserLogin> findByEmail(String email);
	
	Integer findUserIdByEmail(String email);


}
