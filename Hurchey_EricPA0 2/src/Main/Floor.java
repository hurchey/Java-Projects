/**
 * This class is where is a list of the people on each floor.
 * Known Bugs: There is no known bugs currently that I know of. 
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * 02/05/2023
 * COSI 12A PA0
 * 
 */

package Main;

public class Floor {

	/**Fields used for this class*/
	private static final int FLOOR_CAPACITY = 100;
	private int floorNumber;
	private Person person;
	private Person[] peoplePresent;
	Person people;
	String name;
	
	/**Saves a preference of the person in question*/
	public void enterFloor(Person person) {
		this.person = person;
		peoplePresent[getEmptyPosition()] = person;
		return;
	}
	
	
	public Floor(int FloorNumber) {
		this.floorNumber = FloorNumber;
		peoplePresent = new Person[FLOOR_CAPACITY];
		return;
	}
	
	private int getEmptyPosition() {
		int index = 0;
		for(Person human : peoplePresent) {
			if(human == null) {
				return index;
			}
			index++;
		}
		return index;
	}
	
	public int getFloorNumber() {
		return this.floorNumber;
	}
	
	public String toString() {
		return "Floor: " + floorNumber + " has this person: " + person.nameToString();
	}
}

