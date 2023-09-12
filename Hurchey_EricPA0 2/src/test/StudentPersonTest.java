package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Building;
import Main.Person;

class StudentPersonTest {

	@Test
	/**Checks to see if a person is being made*/
	void personTest() {
		Person p1 = new Person("Eric", "Hurchey");
		Person p2 = new Person("Joe", "Biden");
		Person p3 = new Person("", "");
		
		assertEquals(p1.toString(), "Eric Hurchey");
		assertEquals(p2.toString(), "Joe Biden");
		assertEquals(p3.toString(), " ");
	}
	
	@Test
	/**Checks to see if person is going correctly to their desired floor*/
	void enterBuildingTest() {
		Person p1 = new Person("Eric", "Hurchey");
		Person p2 = new Person("Grace", "Wan");
		Person p3 = new Person("Charles", "Wang");
		Person p4 = new Person("Bob", "Bobberson");
		
		Building b = new Building(4);
		
		assertTrue(p1.enterBuilding(b, 4));
		assertTrue(p2.enterBuilding(b, 1));
		assertTrue(p3.enterBuilding(b, 3));
		assertTrue(p4.enterBuilding(b, 2));
	}
	
	@Test
	/**Checking to see when they go to their proper floor, the program is stating the correct
	 * things*/
	void personLocationTest() {
		Person p1 = new Person("Eric", "Hurchey");
		Person p2 = new Person("Grace", "Wan");
		Person p3 = new Person("Charles", "Wang");
		Person p4 = new Person("Bob", "Bobberson");
		
		Building b = new Building(4);
		
		p1.enterBuilding(b, 4);
		p2.enterBuilding(b, 1);
		p3.enterBuilding(b, 3);
		p4.enterBuilding(b, 2);
		
		b.startElevator();
		
		/**Checks to see if the elevator is in the right locations*/
		assertEquals(p1.getLocation(), "In Floor 1");
		assertEquals(p2.getLocation(), "In Floor 2");
		assertEquals(p3.getLocation(), "In Floor 3");
		assertEquals(p4.getLocation(), "In Lobby");
		
	}
}
