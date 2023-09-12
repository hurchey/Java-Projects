/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 11/01/2022
 * PA4
 * This part of the program sets up the finish line that the cars will cross once it hits the specific lap/unit. 
 * Known Bugs: So far there are no issues with this class
 */

package main;

public class FinishLine {

	private Car[] cars;
	public int place;
	/**
	 * Sets up the list of Cars that is in the game
	 * @param cars the inputed amount of Cars that the player wants to have
	 */
	public void setCarList(Car[] cars) {
		this.cars = cars;
		place = 0;
	}
	
	public void enterFinishLine(Car car) {

	}
	/**
	 * 
	 * @return this returns the true or false value if a specific car crossed the finish line or not. 
	 */
	public boolean finished() {
		int len = cars.length;
		for (int i = 0; i < len; i++) {
			if (cars[i].crossedfinishline == true) {
				return true;
			}
		}
		return false;
		
	}
}

