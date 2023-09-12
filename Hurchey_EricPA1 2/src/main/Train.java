/**
* This class represents a Train on the red line. 
* All Trains hold a specified number of passengers in an array, 
* the current number of passengers, the current Station where the Train is, 
* and the Train’s current direction. 
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package main;

public class Train {

	/**Fields that I used for this class*/
	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex, direction;
	public String currentStation;
	
	/**This method will construct an empty Train at a given Station 
	 * going either south (1) or north (0).
	 * Running Time: O(1)*/
	public Train(String currentStation, int direction) {
		this.currentStation = currentStation;
		this.direction = direction;
		this.passengers = new Rider[TOTAL_PASSENGERS];
		this.passengerIndex = 0;
	}
	
	/**This method will return true if this Train is northbound. Else, return false.
	 * Running Time: O(1)*/
	public boolean goingNorth() {
		return this.direction == 0;
	}
	
	/**This method will swap the Train’s direction.
	 * Running Time: O(1)*/
	public void swapDirection() {
		if (direction == 0) {
			this.direction = 1;
		}
		else {
			this.direction = 0;
		}
	}
	
	/**This method will return a String of the current passengers on the Train.
	 * Running Time: O(1)*/
	public String currentPassengers() {
		String curr = "";
		for (int i = 0; i < this.passengerIndex; i++) {
			curr += this.passengers[i].getRiderID() + ", " + this.passengers[i].getDestination() + "\n";
		}
		return curr;
	}
	
	/**This method will add a passenger to the Train as long as 
	 * (i) the Rider is at the correct Station to enter the Train, 
	 * (ii) the Train is going in the appropriate direction, and 
	 * (iii) there is space on the Train. 
	 * Return true if the addition was completed. 
	 * Else, return false.
	 * Running Time: O(1)*/
	public boolean addPassenger(Rider r) {
        if (r != null && r.startingStation.equals(this.currentStation) && r.direction == this.direction && this.hasSpaceForPassengers()) {
			this.passengers[this.passengerIndex++] = r;
			return true;
		}
		return false;
	}
	
	/**This method will return true if the Train has space for additional passengers.
	 * Running Time: O(1)*/
	public boolean hasSpaceForPassengers() {
		return this.passengerIndex < TOTAL_PASSENGERS;
	}
	
	/**This method will remove all of the passengers who should be 
	 * exiting the Train at the Train’s current station. 
	 * It will also return a String of the removed passengers.
	 * Running Time: O(n)*/
	public String disembarkPassengers() {
        String boundString = "";
		boolean skip = false;
		for (int i = 0; i < this.passengerIndex; i++) {
			if (this.passengers[i].destinationStation.equals(this.currentStation)) {
				boundString += this.passengers[i].getRiderID() + "\n";
				this.passengers[i] = passengers[this.passengerIndex - 1];
				this.passengers[this.passengerIndex - 1] = null;
				this.passengerIndex--;
				skip = true;
				i--;
			}
		}
		if (!skip) {
			return boundString;
		}
		String boundDirection = "";
		if (this.direction == 1) {
			boundDirection += "Southbound";
		}
		else {
			boundDirection += "Northbound";
		}
		boundString += "Direction: " + boundDirection + "\n" + "Passengers: \n";
		for (int i = 0;i < this.passengerIndex; i++) {
			boundString += this.passengers[i].getRiderID() + ", " + this.passengers[i].getDestination() + "\n";
		}
		return boundString += "Current station: " + this.currentStation + "\n";
	}
	
	/**This method will updated the name of this Train’s current station 
	 * to be the name of another station.
	 * Running Time: O(1)*/
	public void updateStation(String s) {
		this.currentStation = s;
	}
	
	/**This method will return the name of the Train’s current Station.
	 * Running Time: O(1)*/
	public String getStation() {
		return this.currentStation;
	}
	
	/**This method will return the direction of the Train's current direction.
	 * Running Time: O(1)*/
	public int getDirection() {
		return this.direction;
	}
	
	/**This method will return a String representation of this Train.
	 * Running Time: O(1)*/
	@Override
	public String toString() {
		String trainDirection = "";
		if (this.direction == 1) {
			trainDirection += "South";
		}
		else {
			trainDirection += "North";
		}
		return "The train is at " + this.currentStation 
				+ ", and has " + this.passengerIndex 
				+ " passengers, going " + trainDirection + ".";
	}
}
