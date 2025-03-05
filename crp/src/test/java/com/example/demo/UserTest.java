package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.User;

class UserTest {

	private User user;
	
	@BeforeEach
	public void setUp()
	{
		user = new User(1, "Rohit", "Sharma", "Chennai", "TN", "123 street,adayar", "9876543210", "rohit.sharma@gmail.com");
		
	}
	
	@Test
	public void testGettersAndSetters()
	{
		user.setUserId(2);
		user.setFirstName("Riya");
		user.setLastName("Singh");
		user.setCity("Chennai");
		user.setState("TN");
		user.setAddress("Abc road");
		user.setPhoneNo("1234567890");
		user.setEmail("riyasingh@gmail.com");
		
		assertEquals(2,user.getUserId());
		assertEquals("Riya", user.getFirstName());
		assertEquals("Singh", user.getLastName());
		assertEquals("Chennai",user.getCity());
		assertEquals("TN",user.getState());
		assertEquals("Abc road", user.getAddress());
		assertEquals("1234567890",user.getPhoneNo());
		assertEquals("riyasingh@gmail.com", user.getEmail());
	}
	
	@Test
	public void testDefaultConstructor()
	{
		assertNotNull(user);
		
		User user1 = new User();
		assertEquals(0, user1.getUserId());
        assertNull(user1.getFirstName());
        assertNull(user1.getLastName());
        assertNull(user1.getCity());
        assertNull(user1.getState());
        assertNull(user1.getAddress());
        assertNull(user1.getPhoneNo());
        assertNull(user1.getEmail());

	}
	
	@Test
	public void testParameterizedConstructor()
	{
		assertEquals(1,user.getUserId());
		assertEquals("Rohit", user.getFirstName());
		assertEquals("Sharma", user.getLastName());
		assertEquals("Chennai",user.getCity());
		assertEquals("TN",user.getState());
		assertEquals("123 street,adayar", user.getAddress());
		assertEquals("9876543210",user.getPhoneNo());
		assertEquals("rohit.sharma@gmail.com", user.getEmail());
		
	}

	

}
