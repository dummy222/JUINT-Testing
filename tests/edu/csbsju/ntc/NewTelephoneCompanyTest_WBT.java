package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;

	@Before
	public void setUp() throws Exception {
		ntc = new NewTelephoneCompany();
	}


	@Test (expected=UnsupportedOperationException.class)
	public void testComputeChargeInvalidStarttime() {
		ntc.setStartTime(-5);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected=UnsupportedOperationException.class)
	public void testComputeChargeInvalidDuration() {
		ntc.setStartTime(1800);
		ntc.setDuration(-1);
		ntc.computeCharge();
	}
	
	@Test 
	public void testComputeChargeDiscountedStartTimeandDiscountedDuration() {
		double expectedResult = 1768.0;
		ntc.setStartTime(500);
		ntc.setDuration(100);
		double result = ntc.computeCharge();
		assertTrue("Charge is now " + expectedResult, expectedResult==result);
	}
	
	@Test 
	public void testComputeChargeDiscountedStartTimeOnly() {
		double expectedResult = 1248.0;
		ntc.setStartTime(0);
		ntc.setDuration(60);
		double result = ntc.computeCharge();
		assertTrue("Charge is now " + expectedResult, expectedResult==result);
	}
	
	@Test 
	public void testComputeChargeDiscountedDurationOnly() {
		double expectedResult = 2298.4;
		ntc.setStartTime(800);
		ntc.setDuration(65);
		double result = ntc.computeCharge();
		assertTrue("Charge is now " + expectedResult, expectedResult==result);
	}
	
	@Test 
	public void testComputeChargeNoDiscounts() {
		double expectedResult = 1664.0;
		ntc.setStartTime(1000);
		ntc.setDuration(40);
		double result = ntc.computeCharge();
		assertTrue("Charge is now " + expectedResult, expectedResult==result);
	}



}
