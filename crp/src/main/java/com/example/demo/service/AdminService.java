package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repo.AdminRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminService implements UserDetailsService{
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	 @Autowired
	    private PasswordEncoder encoder;

	    public int login(String email, String password) {
	        String query = "select password from Admin where email = ?";
	        
	        List<String> passwordList = jdbcTemplate.query(query, new Object[] {email}, new RowMapper<String>() {
	            @Override
	            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
	                return rs.getString("password");
	            }
	        });

	        if (passwordList.isEmpty()) {
	            // No user found with the given email
	            return 0;
	        }

	        String storedHashedPassword = passwordList.get(0);

	        // Now verify the provided password with the hashed password using the passwordEncoder instance
	        if (encoder.matches(password, storedHashedPassword)) {
	            // Password matches
	            return 1;
	        } else {
	            // Password doesn't match
	            return 0;
	        }
	    }

	public List<Admin> showAdmin() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

//	public void addAdmin(Admin admin) {
//		// TODO Auto-generated method stub
//		adminRepo.save(admin);
//
//	}
	 public String addAdmin(Admin admin) {
	        admin.setPassword(encoder.encode(admin.getPassword())); 
	        adminRepo.save(admin); 
	        return "Admin Record Inserted...";
	    }
	 
	

	public Optional<Double> getRevenueByCarId(int carid) {
		// TODO Auto-generated method stub
		String cmd = "SELECT SUM(TOTALCOST) FROM Reservation WHERE CARID = ?";

		// Execute the query and process the result
		Double revenue = jdbcTemplate.queryForObject(cmd, new Object[] { carid }, Double.class);

		// Wrap the result in an Optional
		return Optional.ofNullable(revenue);
	}

	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    // Fetch the Admin by email (username)
	    Optional<Admin> adminDetail = adminRepo.findByEmail(username); // Use username here

	    // Converting adminDetail to AdminDetails
	    return adminDetail.map(AdminDetailsSerivice::new)
	            .orElseThrow(() -> new UsernameNotFoundException("Admin not found: " + username)); // Use username here
	}


}
