/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 11/01/2022
 * PA4
 * This part of the program is a continuation of the Car.java program, specifically to call for the RaceCar Car
 * Known Bugs: So far there are no issues with this class
 */

package main;

public class RaceCar extends Car {
	
	/**
	 * This sets up the conditions for the RaceCar class
	 * @param speed to read and print the speed in given parameters
	 * @param strength to read and print the strength in given parameters
	 */
	
	public RaceCar(int speed, int strength) {
		if (speed > 55){
			speed = 55;
		}else if (speed < 30){
			speed = 30;
		}else{
			this.speed = speed;
		}
		if (strength > 4) {
			this.strength = 4;
		}else if (strength < 2){
			this.strength = 2;
		}else{
			this.strength = strength;
		}
		
		lap = 1;
		unit = 0;
		crash = 0;
		newSpeed = 0;
		damagedtorf = false;
		missedaticked = false;
		crossedfinishline = false;
		atPit = false;
		name = "RaceCar";
		originalspeed = speed;
		alreadybeenatpit = false;
		damagedagain = false;
		crashedagain = false;
		damagedunit = 0;
		justdamaged = false; 
		originalstrength = strength;
		damaged = false;
		currentlyAtPit = false;
	}
	
	/**
	 * a general RaceCar assuming that nothing is inputed in its values
	 */
	public RaceCar() {
		this.strength = 3;
		this.speed = 40;
	}

	/**
	 * to call for the RaceCar name 
	 */
	public String toString() {
		return name + originalspeed + "/" + strength;
	}
}
