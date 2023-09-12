/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 11/01/2022
 * PA4
 * This part of the program is the parent class for the other cars and creates and calls for the other sub classes
 * Known Bugs: So far there are no issues with this class
 */

package main;

public abstract class Car {
	/**
	 * these are the values that are being used throughout the whole program
	 */
	public int originalspeed, originalstrength;
	public boolean damaged, currentlyAtPit;
	protected int speed, strength, lap, location, unit, crash, type, newSpeed, pitUnit, damagedunit;
	protected String name;
	protected boolean damagedtorf, missedaticked, crossedfinishline, atPit, alreadybeenatpit, damagedagain, crashedagain, justdamaged;
	
	/**
	 * This sets up the conditions for the Car class
	 * @param speed to read and print the speed in given parameters
	 * @param strength to read and print the strength in given parameters
	 */
	public Car(int speed, int strength) {
		this.speed = speed;
		this.strength = strength;
		lap = 1;
		unit = 1;
		crash = 0;
		newSpeed = 0;
		damagedtorf = false;
		missedaticked = false;
		crossedfinishline = false;
		atPit = false;
		pitUnit = 0;
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
	 * calls for a car
	 */
	public Car() {

	}
	
	/**
	 * this program gets the name of the car that is being inputed
	 * @return the name of the inputed car
	 */
	public String getName() {
	return this.name;
	}

	/**
	 * this program gets the location of a specific car
	 * @return this returns the calculation of a specific location of the car at a given point 
	 */
	public double getLocation() {
		return unit%100;
	}
	
	/**
	 * This sets the speed of the inputed car correctly
	 * @param speed returns the inputed cars speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * This sets the condition of the car
	 * @param damaged if the car is damaged or not
	 * @return returns if the car is damaged or not
	 */
	public boolean Condition(Boolean damaged) {
		return this.damaged;
	}
	
	/**
	 * This program gets the name of the inputed car
	 */
	public abstract String toString();

	/**
	 * this program is to JUnit test the correct values of the cars
	 * @return this will check the values if they are equal or not
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Car){
			Car other = (Car) o;
			return((other.speed == this.speed) && (other.strength == this.strength) && other.name.equals(this.name));
		}
		return false;
	}
}


