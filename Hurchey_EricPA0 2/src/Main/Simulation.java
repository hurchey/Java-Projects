/**
 * This part of the program should call for the size of the building,
 * the people that are going to be used in this program, and what is 
 * their desired floors that they want to go to. 
 * Known Bugs:
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * 02/05/2023
 * COSI 12A PA0
 * 
 */

package Main;

public class Simulation {
	

	public static void main(String[] args) {
		/**Calling an inputed building height*/
		Building building = new Building(4);
		
		/**The people are that are being used in this program*/
		Person p1 = new Person("Eric", "Hurchey");
		Person p2 = new Person("Grace", "Wang");
		Person p3 = new Person("Charles", "Wang");
		Person p4 = new Person("Bob", "Bobberson");
		
		/**A list of people and their desired floors*/
		p1.enterBuilding(building, 1);
		p2.enterBuilding(building, 3);
		p3.enterBuilding(building, 4);
		p4.enterBuilding(building, 1);
		
		/**This makes the whole program start*/
		building.startElevator();
	}
}
