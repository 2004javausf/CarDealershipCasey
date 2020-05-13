package com.cardealer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UnitTest {

	@Test
	void test() {
		assertEquals(1000.00/25, 40.00); //Essentially the math I run to determine the monthly bill using
		//the formula of total cost divided by number of months left. Test shows typing doesn't throw anything off
	}

}
