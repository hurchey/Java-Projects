/**
 * This part of the program holds the information of each person and their desired
 * floor that they want to go to. 
 * Known Bugs: No known bugs that I am aware of.
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * 02/05/2023
 * COSI 12A PA0
 * 
 */

package Main;

public class Person {
	
	/**Fields that were used in this class*/
	private String firstName, lastName, name, location;
	private int currentFloor;
	private int goToFloor;
	private int desiredFloor;
//	private int groundFloor = 0;
	Floor floor;
	Person person;
	Job job;
	Elevator elevator;
	Person names;
	public String peopleNames;
	
	/**Holds information about each person*/
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = firstName + " " + lastName;
		this.peopleNames = name;
	}
	
	/**Holds the information of each person's desired floor*/
	public boolean enterBuilding(Building building, int floor) {
		desiredFloor = floor;
		floor = 0;
		
		building.enterElevatorRequest(this, floor);
		return true;
	}
	
	/**This method gives the location of each person*/
	public String getLocation() {
		
		if (currentFloor == 0) {
			return "Elevator at Lobby"; 
		}
		else if (currentFloor >= 1) {
			return "Elevator at floor: " + currentFloor;
		}
		return "Waiting to be serviced";
		}
	
	/**The following two methods are methods to get the person's name.
	 * While redundant, it is easy to follow each one when applying it 
	 * to other classes. */
	public String toString() {
		return name;
	}
	
	public Person getName() {
		return names;
	}
	
	public String nameToString() {
		return peopleNames;
	}
	
	/**All of the following methods are helper methods to be able to transfer information
	 * from class to class*/
	public int getGoToFloor() {
		return goToFloor;
	}
	
	public void setCurrentFloor(int floor) {
		this.currentFloor = floor;
	}
	
	public int getGroundFloor() {
		return currentFloor;
	}
	
	public void setGroundFloor(int floor) {
		floor = 0;
	}
	
	public void setDesiredFloor(int floor) {
		this.desiredFloor = floor;
	}
	
	public int getDesiredFloor() {
		return desiredFloor;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
}
