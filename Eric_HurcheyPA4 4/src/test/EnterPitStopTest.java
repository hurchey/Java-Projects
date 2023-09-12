/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 11/01/2022
 * PA4
 * This class tests if the cars enter the pit stop
 * Known Bugs: There is no known as of right now
 */

package test;

/**
 * importing the needed finles
 */
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.PitStop;
import main.RaceCar;
import main.Car;
import main.FormulaOne;
import main.SportsCar;

class EnterPitStopTest {
	
	/**
	 * Calling for possible values that I need for this JUnit test
	 * Initialize cars with all types as their default value, then create a list of cars
	 */
	private static PitStop PitStop = new PitStop();
	private static RaceCar race = new RaceCar();
	private static SportsCar sports = new SportsCar();
	private static FormulaOne formula = new FormulaOne();
	private static Car[] carList = {race, sports, formula};
	
	/**
	 * This methods damages the car and reduces its speed
	 */
	void DamageCar(Car car) {
		Boolean damaged = true;
		int speed = car.originalspeed;
		int strength = car.originalstrength;
		int newSpeed = speed - strength * 5;
		car.setSpeed(newSpeed);
		car.Condition(damaged);
		
	}
	/**
	 * This program tests that at the moment that the car is damaged and at the pit stop 
	 */
	@Test
	void EnterPitStoptest() {
		for (int i = 0; i < carList.length; i++) {
			Car Cars = carList[i];
			int originalSpeed = Cars.originalspeed;
			DamageCar(Cars);  //Damaged car
			PitStop.enterPitStop(Cars); //Enters the pit stop
			assertEquals(true, Cars.currentlyAtPit);  //checks if the car entered the pit stop
			assertEquals(originalSpeed, Cars.originalspeed); //checks if the car speed is repaired
		}
	}

}
