/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 11/01/2022
 * PA4
 * 
 * This program test the RaceCar and its values to see if it prints what needs to be printed 
 * Known Bugs: There are no known bugs so far
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.RaceCar;

class RaceCarConstructorTest {
	
	/**
	 * testing to see if the car's values would change to the correct set parameters of the race
	 */
	@Test
	void RaceCartest() {
		RaceCar RC1 = new RaceCar(99999, 1000);
		assertEquals("RaceCar55/4", RC1.toString());
		RaceCar RC2 = new RaceCar(30, 1);
		assertEquals("RaceCar30/2", RC2.toString());
		
	}
	
	/**
	 * this tests to see if the car's values are similar and reads that they are equal to each other
	 */
	@Test
	void RaceCartestequals() {
		RaceCar RC1 = new RaceCar(30, 3);
		RaceCar RC2 = new RaceCar(30, 3);
		assertTrue(RC1.equals(RC2));
	}

}
