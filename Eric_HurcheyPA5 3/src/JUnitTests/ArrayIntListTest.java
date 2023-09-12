/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * Nov 27, 2022
 * PA #5
 * 
 * This ArrayIntListTest class creates tests to test my written ArrayIntList class that it works 
 * properly or not. 
 * 
 * Known Bugs:
 * There are no known bugs currently that I know of.
 */

package JUnitTests;

import org.junit.Test;
import static org.junit.Assert.*;
import main.ArrayIntList;

public class ArrayIntListTest {

	private ArrayIntList arrayList = new ArrayIntList();
	private ArrayIntList arrayListCapacity = new ArrayIntList(5);
	private static int defaultCapacity = 10;
	
	
	/**
	 * This method tests the 
	 * add(int value), add(int index, int value)
	 * toString(), size(), remove(int index), contains(int value) methods
	 */
	@Test
	public void test1() {
		for (int i = 0; i < defaultCapacity; i++) {
			arrayList.add(i+1);
		}
		assertEquals(defaultCapacity, arrayList.size());
		assertEquals(true, arrayList.contains(5));
		String output = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]";
		assertEquals(output, arrayList.toString());
		arrayList.remove(4);
		String outputRemoved = "[1, 2, 3, 4, 6, 7, 8, 9, 10]";
		assertEquals(outputRemoved, arrayList.toString());
		arrayList.add(2, 5);
		String outputAddIndex = "[1, 2, 5, 3, 4, 6, 7, 8, 9, 10]";
		assertEquals(outputAddIndex, arrayList.toString());


	}

	/**
	 * This method tests the 
	 * clear(), isEmpty(), indexOf(int value), get(int index), ensureCapacity(int capacity) methods
	 */
	@Test
	public void test2() {
		arrayListCapacity.ensureCapacity(5);
		assertEquals(5, arrayListCapacity.getLength());
		for (int i = 0; i < 5; i++) {
			arrayListCapacity.add(i+1);
		}
		assertEquals(5, arrayListCapacity.size());
		assertEquals(3, arrayListCapacity.get(2));
		assertEquals(4, arrayListCapacity.indexOf(5));
		arrayListCapacity.clear();
		assertEquals(0, arrayListCapacity.size());
		String outputCleared = "[]";
		assertEquals(outputCleared, arrayListCapacity.toString());
		assertEquals(true, arrayListCapacity.isEmpty());
	}
}
