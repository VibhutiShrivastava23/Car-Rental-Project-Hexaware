package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Car;

class CarTest {

	private Car car;
	
	@BeforeEach
	public void setUp()
	{
		car = new Car(1, "Hyndai","i20", 2020, "Delhi", "available", 2000, "available", "4 seater", "petrol", "manual");
	}
	
	@Test
    public void testParameterizedConstructor() {
        assertEquals(1, car.getCarId());
        assertEquals("Hyndai", car.getMake());
        assertEquals("i20", car.getModel());
        assertEquals(2020, car.getYear());
        assertEquals("Delhi", car.getLocation());
        assertEquals("available", car.getFastag());
        assertEquals(2000, car.getPrice());
        assertEquals("available", car.getAvailability());
        assertEquals("4 seater", car.getCategory());
        assertEquals("petrol", car.getFuelType());
        assertEquals("manual", car.getGearType());
    }
	
	@Test
	public void testGettersAndSetters()
	{
		car.setCarId(2);
		car.setMake("Honda");
		car.setModel("Civic");
		car.setYear(2021);
		car.setLocation("Chennai");
		car.setFastag("available");
		car.setPrice(4500);
		car.setAvailability("available");
		car.setCategory("4 seater");
		car.setFuelType("petrol");
		car.setGearType("manual");
		
	assertEquals(2, car.getCarId());
	assertEquals("Honda", car.getMake());
	assertEquals("Civic", car.getModel());
	assertEquals(2021, car.getYear());
	assertEquals("Chennai", car.getLocation());
	assertEquals("available", car.getFastag());
	assertEquals("available", car.getAvailability());
	assertEquals(4500, car.getPrice());
	assertEquals("4 seater", car.getCategory());
	assertEquals("petrol", car.getFuelType());
	assertEquals("manual", car.getGearType());
	}
	
	@Test
	public void testDefaultConstructor()
	{
		assertNotNull(car);
		
		Car car = new Car();
		assertEquals(0, car.getCarId());
        assertNull(car.getMake());
        assertNull(car.getModel());
        assertEquals(0, car.getYear());
        assertNull(car.getLocation());
        assertNull(car.getFastag());
        assertEquals(0.0, car.getPrice());
        assertNull(car.getAvailability());
        assertNull(car.getCategory());
        assertNull(car.getFuelType());
        assertNull(car.getGearType());
	}
	
	

}
