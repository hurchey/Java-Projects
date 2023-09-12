/**
 * This part of the program is creating job listings for the elevator
 * to read and implement.
 * Known Bugs: There are no known bugs that I am aware of.
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * 02/05/2023
 * COSI 12A PA0
 * 
 */

package Main;

public class Job {
	
	/**Fields used for this class*/
	private Person person;
	private Floor floor;
	private int goToFloor;
	private int desiredFloor;
	Floor floors;

	/**Creating a job listing for the elevator to implement*/
	public Job(Person person, int floor) {
		this.person = person;
		this.goToFloor = floor;
//		floors.enterFloor(person);
	}
	
	/**These of these methods are helper methods*/
	public String toString() {
		return "Person: " + person + " is going to floor: " + goToFloor;
	}
	
	public int getGoToFloor() {
		return goToFloor;
	}
	
	public Person getPerson() {
		return this.person;
	}
}