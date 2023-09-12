package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Building;
import Main.Person;
import Main.Floor;

class StudentFloorTest {

	@Test
	/**This tests to see if the inputed floor is similar to the 
	 * desired floor that the person wants to go to*/
	void floorConstructorTest() {
		Person p1 = new Person("Eric", "Hurchey");
		Building b = new Building(3);
		Floor f = new Floor(3);
		
		assertEquals(f.getFloorNumber(), 3);		
		
		p1.enterBuilding(b, 3);
		b.startElevator();
	}
	
	@Test
	/**This test to see if there is a person on the inputed floor*/
	void floorPersonTest() {
		Person p1 = new Person("Eric", "Hurchey");
		Building b = new Building(3);
		Floor f = new Floor(3);
		
		b.enterElevatorRequest(p1, 3);
		b.startElevator();
		
		
		assertEquals(f.toString(), "Floor: 3 has this person: " + p1);
	}

}
