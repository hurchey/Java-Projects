/**
 * This part of the code should create a building based on the desired input and be able
 * to start the process of the elevator to bring each person to their desired floor
 * Known Bugs: There are no none bugs that I am aware of currently
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * 02/05/2023
 * COSI 12A PA0
 * 
 */

package Main;

public class Building {
	
	/**Fields used for this class*/
	private Floor[] floors;
	private Elevator elevator;
	Person person;
	Floor floor;
	Job job;
	private int currentFloor;
	private int groundFloor = 0;
	private int numFloors;
	
	/**This creates the height of the building*/
	public Building(int numFloors) {
		elevator = new Elevator(this);
		this.numFloors = numFloors;
	}
	
	/**This checks to see if the elevator requested is still true*/
	public boolean enterElevatorRequest(Person person, int floor) {
		elevator.createJob(person, person.getDesiredFloor());
		return true;
	}
	
	/**This is where each person will start to go up using the elevator*/
	public void startElevator() {
		elevator.processAllJobs();
	}
	
	/**Checking to see if each person entered the building*/
	public void enterBuilding(int floor) {
		floor = groundFloor;
		return;
	}
	
	/**Saves a reference of a person in the floor with the provided floor number*/
	public void enterFloor(Person person, int floor) {
		this.person = person;
		this.currentFloor = floor;
		return;
	}
	
	/**The rest of these methods are just helper methods*/
	public Person getPerson(Person person) {
		return this.person = person;
	}
	
	public int getElevatorFloor() {
		return elevator.getCurrentFloor();
	}
	
	public Floor[] getFloors() {
		return floors; 
	}
	
	public String toString() {
		return "This building currently has " + this.numFloors + " floors";
	}
	
	

}
