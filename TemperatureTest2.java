/* Matthew Gray
 * 260454725
 * ECSE321 Assignment 3
 */

import static org.junit.Assert.*;

import org.junit.Test;


public class TemperatureTest2 {

	public double RANGE = 0.000001;
	
	@Test
	public void testGetValue() {
	    //positive, double input value
		Temperature averageHighInOctober = new Temperature (15.0, Temperature.Units.CELSIUS);
		assertEquals("should return 15.0", 15.0, averageHighInOctober.getValue(), RANGE);
	    
		//positive, integer input value, should cast to double
	    Temperature averageHighInNovember = new Temperature (15, Temperature.Units.CELSIUS);
	    assertEquals("should return 15.0", 15.0, averageHighInNovember.getValue(), RANGE);
	    
	    //negative Celsius value, valid
	    Temperature averageHighInDecember = new Temperature (-15.0, Temperature.Units.CELSIUS);
	    assertEquals("should return -15.0", -15.0, averageHighInDecember.getValue(), RANGE);
	    
	    //boundary value for kelvin (cannot go negative)
	    Temperature averageHighInJanuary = new Temperature (0.0, Temperature.Units.KELVIN);
	    assertEquals("should return 0.0", 0.0, averageHighInJanuary.getValue(), RANGE);
	    
	    //valid fahrenheit value
	    Temperature averageHighInApril = new Temperature (15.0, Temperature.Units.FAHRENHEIT);
	    assertEquals("should return 15.0", 15.0, averageHighInApril.getValue(), RANGE);
	    
	    //input more precise than RANGE should be truncated
	    Temperature averageHighInMay = new Temperature (15.123456789, Temperature.Units.FAHRENHEIT);
	    assertEquals("should return 15.123456", 15.123456, averageHighInMay.getValue(), RANGE);
 
	}

	@Test
	public void testGetUnits() {
		//test each unit for getUnits()
		Temperature cels = new Temperature (15, Temperature.Units.CELSIUS);
		assertTrue("should return CELSIUS, actually returns " + cels.getUnits(), cels.getUnits().equals(Temperature.Units.CELSIUS));
	
		Temperature fahr = new Temperature (15, Temperature.Units.FAHRENHEIT);
		assertTrue("should return FARENHEIT, actually returns " + fahr.getUnits(), fahr.getUnits().equals(Temperature.Units.FAHRENHEIT));

		Temperature kelv = new Temperature (15, Temperature.Units.KELVIN);
		assertTrue("should return KELVIN, actually returns " + kelv.getUnits(), kelv.getUnits().equals(Temperature.Units.KELVIN));

	}

	@Test
	public void testChangeUnits() {
		//changeUnits() changed to return the new value of the changed unit
		
		//Celsius to Fahrenheit
		Temperature c2f = new Temperature (15.0, Temperature.Units.CELSIUS);
		assertEquals("should return 59", 59.0, c2f.changeUnits(Temperature.Units.FAHRENHEIT), RANGE);
		 
		//Celsius to Kelvin, negative input test
		Temperature c2k = new Temperature (-15, Temperature.Units.CELSIUS);
		assertEquals("should return 258.15", 258.15, c2k.changeUnits(Temperature.Units.KELVIN), RANGE);
		
		//Kelvin to Celsius, negative output test
		Temperature k2c = new Temperature (15, Temperature.Units.KELVIN);
		assertEquals("should return -258.15", -258.15, k2c.changeUnits(Temperature.Units.CELSIUS), RANGE);
		
		//Kelvin to Fahrenheit
		Temperature k2f = new Temperature (15, Temperature.Units.KELVIN);
		assertEquals("should return -432.67", -432.67, k2f.changeUnits(Temperature.Units.FAHRENHEIT), RANGE);
		
		//Fahrenheit to Celsius, precision test
		Temperature f2c = new Temperature (15, Temperature.Units.FAHRENHEIT);
		assertEquals("should return -9.444444", -9.444444, f2c.changeUnits(Temperature.Units.CELSIUS), RANGE);
		
		//Fahrenheit to Kelvin, precision test
		Temperature f2k = new Temperature (15, Temperature.Units.FAHRENHEIT);
		assertEquals("should return 263.705555", 263.705555, f2k.changeUnits(Temperature.Units.KELVIN), RANGE);
		
	}

}
