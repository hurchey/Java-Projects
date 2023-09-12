package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Building;
import Main.Job;
import Main.Person;

import Main.Elevator;

class StudentElevatorTest {

	@Test
	/**This tests if an elevator exists*/
	void elevatorContrustorTest() {
		Building b = new Building(4);
		Elevator e = new Elevator(b);
		
		assertEquals(e.toString(), "I am an Elevator");
		
	}

}
