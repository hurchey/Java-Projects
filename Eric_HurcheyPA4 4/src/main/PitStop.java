/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 11/01/2022
 * PA4
 * This part of the program runs the car into the pit stop stop and to see if the car is in the pit stop
 * and changing the different values of the car once it enters and exits the pit stop.
 * Known Bugs: So far there are no issues with this class
 */

package main;

public class PitStop {
	/**
	 * changing the values of the car once it enters the pit stop
	 * @param car changing the values of a given inputed car from the list
	 */
	public void enterPitStop(Car car) { 
		car.unit = ((car.unit - car.speed)/100) * 100 + 75;
		car.unit += 0;
		car.atPit = true;
		car.alreadybeenatpit = true;
		car.damagedtorf = true;
		car.damagedagain = true;
		car.damaged = true;
		car.currentlyAtPit = true;
	}
	
	/**
	 * changing the values of the car once it exits the pit stop
	 * @param car changing the values of a given inputed car from the list
	 */
	public void exitPitStop(Car car) {
		car.pitUnit = 0;
		car.atPit = false;
		car.speed = car.originalspeed;
		car.damagedtorf = false;
		car.damagedagain = false;
		car.damaged = false;
	}
}
