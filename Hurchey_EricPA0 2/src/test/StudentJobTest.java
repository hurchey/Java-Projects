package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Building;
import Main.Elevator;
import Main.Person;

import Main.Job;

class StudentJobTest {

	@Test
	/**This tests to see if a job is being created for each person*/
	void jobConstructorTest() {
		Person p = new Person("Eric", "Hurchey");
		Person p2 = new Person("Grace", "Wang");
		Person p3 = new Person("Charles", "Wang");
		Job j = new Job(p, 4);
		Job j2 = new Job(p2, 4);
		Job j3 = new Job(p3, 4);
		
		assertEquals(j.toString(), "Person: Eric Hurchey is going to floor: 4");
		assertEquals(j2.toString(), "Person: Grace Wang is going to floor: 4");
		assertEquals(j3.toString(), "Person: Charles Wang is going to floor: 4");
	}

}
