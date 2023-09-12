/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * Nov 27, 2022
 * PA #5
 * 
 * This SortedIntListTest class creates a list of tests that tests my SortedIntList
 * class to see if the class works properly. 
 * 
 * Known Bugs:
 * There are no known bugs currently that I know of.
 */

package JUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import main.SortedIntList;

public class SortedIntListTest {

	private SortedIntList sortedList = new SortedIntList(true);
	private SortedIntList sortedListCapacity = new SortedIntList(false, 5);
	
	
	
	/**
	 * This method tests the SortedIntList(boolean unique) constructor and
	 * add(int value), toString(), indexOf(int value), min() methods
	 */
	@Test
	public void test1() {
		sortedList.add(10);
		sortedList.add(8);
		sortedList.add(8);
		sortedList.add(7);
		sortedList.add(5);
		sortedList.add(8);
		sortedList.add(12);
		sortedList.add(14);
		sortedList.add(2);
		sortedList.add(3);
		String output = "S: [2, 3, 5, 7, 8, 10, 12, 14]U";
		assertEquals(output, sortedList.toString());
		assertEquals(4, sortedList.indexOf(8));
		assertEquals(14, sortedList.max());
		assertEquals(2, sortedList.min());
	}

	/**
	 * This method tests the SortedIntList(boolean unique, int capacity) constructor and
	 * setUnique(boolean value), getUnique() methods
	 */
	@Test
	public void test2() {
		sortedListCapacity.add(8);
		sortedListCapacity.add(5);
		sortedListCapacity.add(8);
		sortedListCapacity.add(7);
		String output = "S: [5, 7, 8, 8]";
		assertEquals(output, sortedListCapacity.toString());
		sortedListCapacity.setUnique(true);
		String outputUnique = "S: [5, 7, 8]U";
		assertEquals(outputUnique, sortedListCapacity.toString());
		assertEquals(true, sortedListCapacity.getUnique());
	}

}
