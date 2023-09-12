/**
* This class represents the red line railway and is made up of a list of Stations.
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package main;

import main.DoubleLinkedList;
import java.util.*;

public class Railway {

	/**Fields that I used for this class*/
	public DoubleLinkedList<Station> railway;
	public String[] stationNames;
	public int index;
	
	/**This method will construct an empty Railway.
	 * Running Time: O(1)*/
	public Railway() {
		 railway = new DoubleLinkedList<Station>();
	     stationNames = new String[18];
	}
	
	/**This method will add a Station to the Railway.
	 * Running Time: O(1)*/
	public void addStation(Station s) {
		railway.insert(s);
        stationNames[railway.size() - 1] = s.stationName();
	}
	
	/**This method will (i) set a Rider’s direction based on the order of the Stations in the Railway and 
	 * (ii) add the Rider to the appropriate Station in the Railway.
	 * Running Time: O(n)*/
	public void addRider(Rider r) {
		Node<Station> current = railway.getFirst();
		for (int i = 0; i < railway.size; i++) {
			if (current.getData().stationName().equals(r.getStarting())) {
				setRiderDirection(r);
				current.getData().addRider(r);
			}
			current = current.getNext();
		}
	}
	
	/**This method will add a Train to the appropriate Station in this Railway.
	 * Running Time: O(n)*/
	public void addTrain(Train t) {
		Node<Station> current = railway.getFirst();
		for(int i = 0; i < railway.size(); i++) {
			if(current.getData().stationName().equals(t.getStation())) {
				current.getData().addTrain(t);
			}
			current = current.getNext();
		}
	}
	
	/**This method will set a Rider’s direction based on the Rider’s starting and ending Stations.
	 * Running Time: O(n)*/
	public void setRiderDirection(Rider r) {
		int startStation = 1;
		int endStation = 1;
		for (int i = 0; i < this.index; i++) {
			if (r.getStarting().equals(this.stationNames[i])) startStation += endStation;
			else if (r.getDestination().equals(this.stationNames[i])) endStation += startStation;
		}
		if (startStation == 2 && r.goingNorth()) {
			r.swapDirection();
			return;
		}
		else if (startStation == 3 && !r.goingNorth()) {
			r.swapDirection(); 
			return;
		}
	}
	
	/**This method will execute one simulation of the Railway. 
	 * It will log the events that occur in the process of your simulation such as 
	 * the status of each Station, where Trains and Riders are, and when Riders exit a Train. 
	 * This log will be returned by this method for use in the main class MBTA.java.
	 * Running Time: O(n^2)*/
	public String simulate() {
		String result = "";
        Node<Station> currentNode = this.railway.getFirst();
        while (currentNode != null) {
            boolean switchToSouth = false;
            boolean switchToNorth = false;
            Queue<Train> southTrains = currentNode.data.southBoundTrains;
            Queue<Train> northTrains = currentNode.data.northBoundTrains;
            result += currentNode.getData().toString() + "\n";
            if (northTrains.size() != 0) {
                if (currentNode.getData().stationName().equals("Alewife")) {
                	switchToSouth = true;
                }
                else {
                    Train added = currentNode.getData().northBoardTrain();
					added.updateStation(currentNode.prev.getData().stationName());
					result += currentNode.prev.getData().addTrain(added)+"\n";
                }
            }
            Station currentData = currentNode.getData();
            if (southTrains.size() != 0) {
                if (currentNode.getData().stationName().equals("Braintree")) {
                	switchToNorth = true;
                }
                else {
                    Train added = currentNode.getData().southBoardTrain();
					added.updateStation(currentNode.next.getData().stationName());
					result += currentNode.next.getData().addTrain(added) + "\n";
                }
            }
            if (switchToNorth) {
            	currentData.moveTrainSouthToNorth();
            }
            if (switchToSouth) {
            	currentData.moveTrainNorthToSouth();
            }
            currentNode = currentNode.next;
        }
		return result;
	}
	
	/**This method will return the Stations list’s String representation.
	 * Running Time: O(n)*/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("Railway stations: ");
	    for (int i = 0; i < railway.size(); i++) {
	        sb.append(railway.head);
	        if (i < railway.size() - 1) {
	            sb.append(" - ");
	        }
	    }
	    return sb.toString();
	}
}