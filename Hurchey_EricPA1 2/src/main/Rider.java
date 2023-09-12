/**
* This class represents a Rider on the red line. 
* A rider has an ID, starting station, destination station, and a direction.
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package main;

public class Rider {

	/**Fields that I used for this class*/
	public String riderID, startingStation, destinationStation;
	public boolean goingNorth;
	public int direction;
	
	/**This method will construct a Rider with an ID as well as starting and 
	 * ending stations. The Rider will start by traveling south. 
	 * A Rider will be traveling at least 1 Station.
	 * Running Time: O(1)*/
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID = riderID;
        this.startingStation = startingStation;
        this.destinationStation = destinationStation;
        this.direction = 1;
	}
	
	/**This method will return the name of this Rider’s starting station.
	 * Running Time: O(1)*/
	public String getStarting() {
		return startingStation;
	}
	
	/**This method will return the name of this Rider’s ending station.
	 * Running Time: O(1)*/
	public String getDestination() {
		return destinationStation;
	}
	
	/**This method will return this Rider’s ID.
	 * Running Time: O(1)*/
	public String getRiderID() {
		return riderID;
	}
	
	/**This method will return true if this Rider is northbound. Else, false.
	 * Running Time: O(1)*/
	public boolean goingNorth() {	
		return this.direction == 0;
	}
	
	/**This method will swap the Rider’s current direction.
	 * Running Time: O(1)*/
	public void swapDirection() {
		this.direction = -this.direction;
	}
	
	/**This is a helper method
	 * Running Time: O(1)*/
	public int getDirection() {
		return direction;
	}
	
	/**This method will return a String representation of this Rider.
	 * Running Time: O(1)*/
	@Override
	public String toString() {
		String bound = "";
		if (this.direction == 1) {
			bound += "South";
		}
		else bound += "North";
		return "Rider with ID " + this.riderID + ", starting from " 
				+ this.startingStation + ", and going to " 
				+ this.destinationStation + ", " + bound + "bound.";
	}
	
	/**This method will check if this Rider is equal to another Object based on ID.
	 * Running Time: O(1)*/
	@Override
	public boolean equals(Object s) {
		if (s == this) {
            return true;
        }
        if (!(s instanceof Rider)) {
            return false;
        }
        Rider other = (Rider) s;
        return riderID.equals(other.getRiderID());
    }
}
