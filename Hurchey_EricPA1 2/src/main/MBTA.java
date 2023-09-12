/**
* This class contains the program’s main method and runs a simulation of a Railway. 
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MBTA {

	/**Fields that I used for this class*/
	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	
	/**This method starts the simulation and reading the given text files
	 * Running Time: O(n^2)*/
	public static void main(String[] args) throws FileNotFoundException {
		r = new Railway();
		
		String stationsFile = "redLine.txt";
        String ridersFile = "riders.txt";
        String trainsFile = "trains.txt";

        initStations(stationsFile);
        initRiders(ridersFile);
        initTrains(trainsFile);

        System.out.println("INITIATED RED LINE" + "\n");
		Node<Station> curr = r.railway.getFirst();
		while (curr != null) {
			System.out.println(curr.getData().toString());
			curr = curr.next;
		}
        
        runSimulation();
	}
	
	/**This method will run the simulation n * TIMES
	 * Running Time: O(TIMES * n^2)*/
	public static void runSimulation() {
		String simulation = "";
        System.out.println("INITIATED RED LINE" + "\n");
		
		for (int i = 0; i < TIMES; i++) {
			simulation += "------ " + (i + 1) + " ------\n\n";
            simulation += r.simulate();
        }
		System.out.println(simulation);
	}
	
	/**This method will read the trains text file
	 * Running Time: O(n^2)*/
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		try {
			Scanner Scanner = new Scanner(new File(trainsFile));		
			String string = "";
			int num = 0;
			while (Scanner.hasNextLine()) {
	            string = Scanner.nextLine();
	            num = Scanner.nextInt();
	            if (Scanner.hasNextLine()) Scanner.nextLine();
				r.addTrain(new Train(string, num));
			}
		}
		catch(FileNotFoundException e) {
			 System.err.println("Error: " + e.getMessage());
		}
	}
	
	/**This method will read the riders text file
	 * Running Time: O(n^2)*/
	public static void initRiders(String ridersFile) throws FileNotFoundException {
		try {
			Scanner Scanner = new Scanner(new File(ridersFile));
			while (Scanner.hasNextLine()) {
				r.addRider(new Rider(Scanner.nextLine(), Scanner.nextLine(), Scanner.nextLine()));
			}
		}
		catch (FileNotFoundException e) {
			 System.err.println("Error: " + e.getMessage());
		}
	}
	
	/**This method will read the stations text file
	 * Running Time: O(n^2)*/
	public static void initStations(String stationsFile) throws FileNotFoundException {
		try {
			Scanner Scanner = new Scanner(new File(stationsFile));
			while (Scanner.hasNextLine()) {
				r.addStation(new Station(Scanner.nextLine()));
			}
		}
		catch(FileNotFoundException e) {
			System.out.print("Error: " + e.getMessage());
		}
	}
}
