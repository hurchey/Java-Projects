/**
* This class represents a Station on the red line. 
* A Station tracks which Trains and Riders are waiting to go north or south.
* Known Bugs: There is a slight bug where it is not able to print out some the other passengers. But
* other than that, there is no major error with this code and runs everything else smoothly.
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package main;

public class Station {

	/**Fields that I used for this class*/
	public static final int PEOPLE_TRAIN = 20;
	
	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	
	public String name;
	
	/**This method will represent a Station on the red line. 
	 * A Station will track which Trains and Riders are waiting to go north or south.
	 * Running Time: O(1)*/
	public Station(String name) {
		this.name = name;
		this.northBoundRiders = new Queue<Rider>(Station.PEOPLE_TRAIN);
		this.northBoundTrains = new Queue<Train>(Station.PEOPLE_TRAIN);
		this.southBoundRiders = new Queue<Rider>(Station.PEOPLE_TRAIN);
		this.southBoundTrains = new Queue<Train>(Station.PEOPLE_TRAIN);
	}
	
	/**This method will add a Rider to the appropriate Queue, 
	 * depending on the Rider’s direction, as long as they should be in this Station. 
	 * Return true if this is possible and false otherwise.
	 * Running Time: O(1)*/
	public boolean addRider(Rider r) {
		if (r != null) {
			if (r.goingNorth()) {
				this.northBoundRiders.enqueue(r);
			}
			else {
				this.southBoundRiders.enqueue(r);
			}
			return true;
		}
		return false;
	}
	
	/**This method will move a Train into this Station, 
	 * removes all of the passengers who are meant to disembark at this Station, 
	 * and places the Train in the appropriate Queue depending on its direction. 
	 * This method will return a String that includes that some passengers were 
	 * removed at this Station
	 * Running Time: O(1)*/
	public String addTrain(Train t) {
		if (t != null) {
			if (t.goingNorth()) {
				this.northBoundTrains.enqueue(t);
			}
			else {
				this.southBoundTrains.enqueue(t);
			}
		}
		return this.name + " Disembarking Passengers:\n" + t.disembarkPassengers();
	}
	
	/**This method will prepare a southbound Train of passengers
	 * Running Time: O(n)*/
	public Train southBoardTrain() {
		if (this.southBoundTrains.front() == null) {
			return null;
		}
		while (this.southBoundTrains.front().hasSpaceForPassengers() && 
			   this.southBoundRiders.size() != 0) 
		{
			this.southBoundTrains.front().addPassenger(this.southBoundRiders.front());
			this.southBoundRiders.dequeue();
		}
		Train t = this.southBoundTrains.front();
		this.southBoundTrains.dequeue();
		return t;
	}
	
	/**This method will prepare a northbound Train of passengers 
	 * Running Time: O(1)*/
	public Train northBoardTrain() {
		if (this.northBoundTrains.front() == null) {
			return null;
		}
		while (this.northBoundTrains.front().hasSpaceForPassengers() && 
		       this.northBoundRiders.size() != 0) 
		{
		    this.northBoundTrains.front().addPassenger(this.northBoundRiders.front());
		    this.northBoundRiders.dequeue();
		}
		Train t = this.northBoundTrains.front();
		this.northBoundTrains.dequeue();
		return t;
	}
	
	/**This method will change the direction of the first waiting 
	 * northbound Train and moves it to the southbound queue. 
	 * Running Time: O(1)*/
	public void moveTrainNorthToSouth() {
		if (this.northBoundTrains.front() == null) {
			return;
		}
	     Train t = new Train(northBoundTrains.front().getStation(), 1);
	     t.swapDirection();
	     northBoundTrains.dequeue();
	     southBoundTrains.enqueue(t);
	}
	
	/**This method will change the direction of the first waiting 
	 * southbound Train and moves it to the northbound queue. 
	 * Running Time: O(1)*/
	public void moveTrainSouthToNorth() {
		if (this.southBoundTrains.front() == null) {
			return;
		}
        Train t = new Train(southBoundTrains.front().getStation(), 0);
        t.swapDirection();
	    southBoundTrains.dequeue();
	    northBoundTrains.enqueue(t);
	}
	
	/**This method will return the name and status of the station.
	 * Running Time: O(1)*/
	@Override
	public String toString() {
		return "Station: " + this.name + "\n" +
	    northBoundTrains.size() + " north-bound trains waiting\n" +
	    southBoundTrains.size() + " south-bound trains waiting\n" +
	    northBoundRiders.size() + " north-bound passengers waiting\n" +
	    southBoundRiders.size() + " south-bound passengers waiting\n";
	}
	
	/**This method will return the name of this Station
	 * Running Time: O(1)*/
	public String stationName() {
		return this.name;
	}
	
	/**This method will check if a Station is equal to some object based on name.
	 * Running Time: O(1)*/
	@Override
	public boolean equals(Object o) {
		if (o == this) {
            return true;
        }
        if (!(o instanceof Station)) {
            return false;
        }
        Station s = (Station) o;
        return s.name.equals(this.name);
	}
}
