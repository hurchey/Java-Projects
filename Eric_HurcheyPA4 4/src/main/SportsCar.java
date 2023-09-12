/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 11/01/2022
 * PA4
 * This part of the program is a continuation of the Car.java program, specifically to call for the SportsCar
 * Known Bugs: So far there are no issues with this class
 */

package main;

public class SportsCar extends Car{
	
	/**
	 * This sets up the conditions for the SportsCar class
	 * @param speed to read and print the speed in given parameters
	 * @param strength to read and print the strength in given parameters
	 */
	public SportsCar(int speed, int strength) {
		if (speed > 45){
			speed = 45;
		}else if (speed < 20){
			speed = 20;
		}else{
			this.speed = speed;
		}
		if (strength > 3) {
			this.strength = 3;
		}else if (strength < 1){
			this.strength = 1;
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
		name = "SportsCar";
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
	 * a general SportsCar assuming that nothing is inputed in its values
	 */
	public SportsCar(){
		this.speed = 30;
		this.strength = 2;
	}
	/**
	 * to call for the SportsCar name 
	 */
	public String toString() {
		return name + originalspeed + "/" + strength;
	}
}
