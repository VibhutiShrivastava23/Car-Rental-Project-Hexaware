package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserLogin;
import com.example.demo.repo.UserLoginRepository;

@Service
public class UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int login(String email, String pwd) {
        String query = "SELECT COUNT(*) AS cnt FROM UserLogin WHERE email = ? AND password = ?";

        List<Integer> result = jdbcTemplate.query(query, new Object[] { email, pwd }, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("cnt");
            }
        });

        if (result.isEmpty()) {
            return 0;
        }

        Integer count = result.get(0);
        return count;
    }
	
	public int getUserId(String email) {
	    String query = "SELECT userId FROM UserLogin WHERE email = ?";
	    
	    Integer userId = jdbcTemplate.queryForObject(query, new Object[]{email}, Integer.class);
	    
	    return userId != null ? userId : -1;
	}

	
	public String resetPassword (String email, String password)
	{
		UserLogin userLogin = userLoginRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not found with email: "+email));
		
		userLogin.setPassword(password);
		userLoginRepo.save(userLogin);
		
		return "Password updated Successfully";
	}
	
}
