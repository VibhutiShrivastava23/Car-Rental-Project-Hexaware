package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Reservation;

class ReservationTest {

	 private Reservation reservation;
	 private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 
//	 @BeforeEach
//	 public void setUp() throws ParseException
//	 {
//		 reservation = new Reservation(1, 1, 5,sdf.parse("2024-09-05"),sdf.parse("2024-09-06"),4000.0, 1200.0, "pending");
//	 }
//	 
//	 @Test
//	 public void testGettersAndSetters() throws ParseException
//	 {
//		 reservation.setResId(2);
//	     reservation.setUserId(1);
//	     reservation.setCarId(1);
//	     reservation.setPickupDate(sdf.parse("2024-09-10"));
//	     reservation.setDropDate(sdf.parse("2024-09-10"));
//	     reservation.setTotalCost(2000.0);
//	     reservation.setAdvanceAmount(1200.0);
//	     reservation.setStatus("pending");
//	     
//	     assertEquals(2, reservation.getResId());
//	     assertEquals(1, reservation.getUserId());
//	     assertEquals(1, reservation.getCarId());
//	     assertEquals(sdf.parse("2024-09-10"), reservation.getPickupDate());
//	     assertEquals(sdf.parse("2024-09-10"), reservation.getDropDate());
//	     assertEquals(2000.0, reservation.getTotalCost());
//	     assertEquals(1200.0, reservation.getAdvanceAmount());
//	     assertEquals("pending", reservation.getStatus());
//	 }
//	 
//	 @Test
//	    public void testParameterizedConstructor() throws ParseException {
//	     
//	        assertEquals(1, reservation.getResId());
//	        assertEquals(1, reservation.getUserId());
//	        assertEquals(5, reservation.getCarId());
//	        assertEquals(sdf.parse("2024-09-05"), reservation.getPickupDate());
//	        assertEquals(sdf.parse("2024-09-06"), reservation.getDropDate());
//	        assertEquals(4000.0, reservation.getTotalCost());
//	        assertEquals(1200.0, reservation.getAdvanceAmount());
//	        assertEquals("pending", reservation.getStatus());
//	    }
//	 
//	    @Test
//	    public void testDefaultConstructor() {
//	       
//	        Reservation reservation1 = new Reservation();
//	        
//	        assertNotNull(reservation1);
//	        assertEquals(0, reservation1.getResId());
//	        assertEquals(0, reservation1.getUserId());
//	        assertEquals(0, reservation1.getCarId());
//	        assertNull(reservation1.getPickupDate());
//	        assertNull(reservation1.getDropDate());
//	        assertNull(reservation1.getTotalCost());
//	        assertNull(reservation1.getAdvanceAmount());
//	        assertNull(reservation1.getStatus());
//	    }
//	 
}
