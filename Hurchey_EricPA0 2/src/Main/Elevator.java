/**
 * This part of the program is where mostof the magic happens where each peerson
 * will get on the elevator and be let off in their respective floor location. 
 * Known Bugs: This program is able to send each person to their desired floor in order of request,
 * but it is unable to have a max occupant on the elevator.
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * 02/05/2023
 * COSI 12A PA0
 * 
 */

package Main;

public class Elevator {

	/**
	 * This specifies the number of people that can be brought to their floors by an Elevator 
	 * instance at any given time. 
	 * <p>DO NOT REMOVE THIS FIELD</p>
	 * <p>You may edit it. But keep it public.</p>
	 */
	public static int maxOccupants = 3;
	private Person personInTheElevator;
	private int currentFloor;
	private int indexJob = 0;
	private int FloorExit;
	private Job[] jobs;
	Building building;
	Floor floor;
	Person person;
	Job job;
	
	
	public Elevator (Building building) {
		this.building = building;
		jobs = new Job[10];
		this.currentFloor = 0;
	}
	
	public String toString() {
		return "I am an Elevator";
	}
	
	public void createJob(Person person, int floor) {
		Job job = new Job (person, person.getDesiredFloor());
		jobs[indexJob] = job;
		indexJob++;
		return;
	}
	
	public void processAllJobs() {
		while (jobs[0] != null) {
			processJob(jobs[0]);
			jobs[0] = null;
			cleanUpJobs();
		}
		
	}
	
	public void processJob(Job job) {
		goToBottomFloor(job.getPerson().getDesiredFloor());
		indexJob--;
		if (jobs[0] == null) {
			exit(personInTheElevator, personInTheElevator.getGoToFloor());
			person.setCurrentFloor(currentFloor);

		}
		return;
	}
	
	public void gettingFloors() {
		for(int i = currentFloor; i <= job.getGoToFloor(); i++) {
			person.setCurrentFloor(i);
		}
	}
	
	public void cleanUpJobs() {
		for (int i = 0; i < jobs.length - 1; i++) {
			jobs[i] = jobs[i + 1];
			
		}
	}
	
	public void exit(Person person, int floor) {
		building.enterFloor(person, floor);
		person.setCurrentFloor(this.currentFloor);
		jobs[0] = null;
		this.FloorExit = this.currentFloor;
		return;
	}
	
	public Person getPerson(Person person) {
		this.person = person.getName();
		return this.person;
	}
	
	public String exitToString() {
		return this.person + "is leaving floor: " + this.FloorExit;
	}

	public Person getPersonInTheElevator() {
		return personInTheElevator;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	private void goToBottomFloor(int currentFloorPerson) {
		int constantFloor = this.currentFloor;
		if(this.currentFloor > currentFloorPerson || indexJob > maxOccupants) {

				for (int i = constantFloor; i >= currentFloorPerson; i--) {
					this.currentFloor = i;
					if(this.currentFloor == 0) {
						System.out.println("Elevator at lobby");
					}
					else if(this.currentFloor >= 1) {
						System.out.println("Elevator is at floor: " + this.currentFloor);
					}
					
				}
			
		}
		else if(this.currentFloor < currentFloorPerson && indexJob < maxOccupants){
			
				for(int i = constantFloor; i <= currentFloorPerson; i++) {
					this.currentFloor = i;
					if(this.currentFloor == 0) {
						System.out.println("Elevator at lobby");
					}
					else if(this.currentFloor >= 1) {
						System.out.println("Elevator is at floor: " + this.currentFloor);
					}
				}
		}
	}
}
