package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Building;
import Main.Person;

class StudentBuildingTest {

	/**
	 * This test will test if any inputed building number will say that that building
	 * has that many inputed floors.
	 */
	@Test
	void buildingConstructorTest() {
		Building b1 = new Building(1);
		assertEquals(b1.toString(), "This building currently has 1 floors");
		
		Building b2 = new Building(999);
		assertEquals(b2.toString(), "This building currently has 999 floors");
	}
	
	/**
	 * This test will test if the person inputs a request that is not within
	 * the range of the building
	 */
	@Test
	void peopleInvalidTest() {
		Person p1 = new Person("Eric", "Hurchey");
		Person p2 = new Person("Grace", "Wang");
		Person p3 = new Person("William", "Wu");
		Person p4 = new Person("Charles", "Wang");
		Person p5 = new Person("Kass", "Han");
		
		Building b = new Building(20);
		
		p1.enterBuilding(b, -1);
		p2.enterBuilding(b, 20);
		p3.enterBuilding(b, 999);
		p4.enterBuilding(b, -666);
		p5.enterBuilding(b, 14);
		
		assertEquals(b.toString(), "This building currently has 20 floors");
		
	}
	
	@Test
	void queueTest() {
		Person p1 = new Person("Eric", "Hurchey");
		Person p2 = new Person("Grace", "Wang");
		Person p3 = new Person("William", "Wu");
		Person p4 = new Person("Charles", "Wang");
		Person p5 = new Person("Kass", "Han");
		
		Building b = new Building(14);
		
		p1.enterBuilding(b, 1);
		p2.enterBuilding(b, 2);
		p3.enterBuilding(b, 3);
		p4.enterBuilding(b, 5);
		p5.enterBuilding(b, 8);
		
		assertEquals(b.toString(), "This building currently has 14 floors");
		
	}
	
	
	
}
