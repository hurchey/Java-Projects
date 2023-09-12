/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 11/01/2022
 * PA4
 * This part of the program runs the Race game.
 * Known Bugs: In general, the game runs as intended as seen in the first JUnit Test, but in the JUnit tests, the car is unable to enter the PitStop again but the size of the race is correct.
 * The cars in the JUnit tests still leave the race at the given times. 
 * In one of the JUnit Tests, the ticks of the race is off by one tick. 
 * Some of the cars enters the pit stop some of them do not. 
 */

package main;

/**
 * This is me calling of the variables that used for this program
 */
public class RaceTrack {
	private static int totalscore = 0;
	int ticks;
	Car[] numCars;
	int numF1;
	int numSC;
	int numRC;
	
	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
	 */
	private TrackLoggerC logger;
	private FinishLine finishline;
	private PitStop pit;
	public boolean alreadybeenatpit;
	
	public RaceTrack() {
		logger = new TrackLoggerC(); // DO NOT REMOVE THIS LINE
		finishline = new FinishLine();
		pit = new PitStop();
		ticks = 0;
	}
	/**
	 * this part of the program calls for the list of cars being used and counts how many of them are in the list
	 * @param cars the inputed list 
	 */
	public void setCars(Car[] cars) {
		if (cars.length > 10) {
			this.numCars = new Car[10];
			for (int i = 0; i < 10; i++) {
				numCars[i] = cars[i];
			}		
		} else {
			this.numCars = cars;
		}for (int i = 0; i < numCars.length; i++) {
			if(numCars[i] instanceof SportsCar) {
				numSC++;
			}if(numCars[i] instanceof FormulaOne) {
				numF1++;
			}if(numCars[i] instanceof RaceCar) {
				numRC++;
			}
		}
		finishline.setCarList(this.numCars);
	}
	
	/**
	 * this part of the program calls for ticks and prints and counts the amount of them.
	 */
	public void tick() {
		logger.logNewTick();
		ticks++;
		/**
		 * this part of the code checks the certain conditions that must be accepted for the car to enter the pit stop.
		 */
		for(int i = 0; i < numCars.length; i++){
			if (numCars[i] != null) {
				numCars[i].unit += numCars[i].speed;
				checkCollision();
				if(numCars[i].damagedtorf){
					if((numCars[i].unit - numCars[i].speed) % 100 < 75) {
						if((numCars[i].unit % 100) > 75) {
							if (!numCars[i].alreadybeenatpit|| numCars[i].damagedunit > 1) { 
								pit.enterPitStop(numCars[i]);
								logger.logEnterPit(numCars[i]);

							}
							else if(numCars[i].justdamaged && !numCars[i].alreadybeenatpit && numCars[i].damagedunit > 1){
								pit.enterPitStop(numCars[i]);
								logger.logEnterPit(numCars[i]);
							}
							
						}
					}
				}
				/**
				 * this part of the code checks the conditions of the car if it is good enough to exit the pit stop
				 */
				if (numCars[i].atPit) {
					numCars[i].pitUnit++;
						if(numCars[i].pitUnit > 2) {
							pit.exitPitStop(numCars[i]);
							logger.logExitPit(numCars[i]);
							numCars[i].unit += numCars[i].speed;
						}
				}
				/**
				 * this part of the code checks if the car is at the finish line and enters the car into it
				 */
				if(numCars[i].unit % 100 < 75) {
					if (numCars[i].unit >= 1000) {
						finishline.enterFinishLine(numCars[i]);
						finishline.place++;
						logger.logFinish(numCars[i], finishline.place);
						numCars[i] = null;
					}
				}
			}
		}
	}

	/**
	 * This part of the program checks if two cars in the list of cars have crashed.
	 */
	public void checkCollision() {
		for (int i = 0; i < numCars.length; i++) {
			if(numCars[i] != null) {
				for (int j = i+1; j < numCars.length; j++) {
					if(numCars[j] != null) {
						/**
						 * this part of the program checks if two cars are at the same location which also means the cars crashed
						 */
						if ((numCars[i].getLocation() == numCars[j].getLocation()) && numCars[i].getLocation() != 0 && numCars[i].getLocation() < 1000 && numCars[j].getLocation() != 0 && numCars[j].getLocation() < 1000) {
							/**
							 * changing the speed of one of the crashed cars
							 */
							if (!numCars[i].damagedtorf && ticks > 9) {
								numCars[i].speed = numCars[i].speed - (numCars[i].strength * 5);
								logger.logDamaged(numCars[i]);
								numCars[i].damagedtorf = true;
								numCars[i].damagedunit++;
							}
							/**
							 * changing the speed of the other car that crashed
							 */
							if(!numCars[j].damagedtorf && ticks > 9) {
								numCars[j].speed = numCars[j].speed - (numCars[j].strength * 5);
								logger.logDamaged(numCars[j]);
								numCars[j].damagedtorf = true;
								numCars[i].damagedunit++;
							}	
						}
					}
				}
			}
		}
	}
	
	/**
	 * This part of the program allows for all off the other aspects of the program to work and function and incorporating each of their different parts.
	 */
	public void run() {
		while(finishline.place != numCars.length) {
			tick();
		}
		logger.logScore(calculatorScore(totalscore));
	}
	/**
	 * this returns an integer value of the score for the race
	 * @param ticks using the ticks calculated from before
	 * @return the score of the ticks
	 */
	public int calculatorScore(int ticks) {
		totalscore = 1000 - (20 * this.ticks) + (150 * numRC) + (100 * numF1) + (200 * numSC); 
		return totalscore;
	}
	
	/**
	 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
	 * @return logger with this track's events 
	 */
	public TrackLoggerC getLogger() {
		return logger;
	}
}
