package com.cardealer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UnitTest {

	@Test
	void testDecimals() {
		assertEquals(1000.00/25, 40.00); //Essentially the math I run to determine the monthly bill using
		//the formula of total cost divided by number of months left. Test shows typing doesn't throw anything off
	}
	void testPrecisionLossThroughHandoff() {
		//showing the same functionality works correctly even after multiple variable handoffs as occurs during the program
		double a=5.723451209898;
		double b=a;
		double c=b;
		double d=c;
		double e=d;
		assertEquals(e, 5.723451209898);
	}

}
