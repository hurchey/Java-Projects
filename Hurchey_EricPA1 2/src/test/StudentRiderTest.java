/**
* This class tests the Rider class that I made in the main package
* It was a test that was provided already. 
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Rider;

class StudentRiderTest {

	Rider r;
	
	@Test
	void initTest() {
		r = new Rider("abc123", "Alewife", "Braintree");
		
		assertEquals("abc123", r.getRiderID());
		assertEquals("Alewife", r.getStarting());
		assertEquals("Braintree", r.getDestination());
		assertFalse(r.goingNorth());

	}
	
	@Test
	void testEquals() {
		r = new Rider("abc123", "Alewife", "Braintree");
		Rider r1 = new Rider("abc123", "a", "b");
		assertEquals(r1, r);
	}
	
	

}
