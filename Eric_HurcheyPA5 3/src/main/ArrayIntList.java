/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * Nov 27, 2022
 * PA #5
 * 
 * This ArrayIntList class creates a list of integers and the size of the list is based on the 
 * capacity variable.
 * 
 * Known Bugs:
 * There are no known bugs currently that I know of.
 */

package main;

import java.util.*;

public class ArrayIntList {
	/**
	 * These are all of the variables that I used for this part of the class. 
	 */
	private static final int defaultcapacity = 10;
	private int[] arraylist;
	private int numOfElements;
	
	/**
	 * This method creates an empty list which the size is set to the default size of 10.
	 */
	public ArrayIntList() {
		arraylist = new int[defaultcapacity];
		setIndex();
		return;
	}
	
	/**
	 * This method creates an empty list which the size is set to the capacity variable size.
	 * @param capacity: this uses the number that is inputed and creates an empty list based 
	 * upon this number.
	 */
	public ArrayIntList(int capacity) {
		arraylist = new int[capacity];
		setIndex();
		return;
	}
	
	/**
	 * This method adds a variable at the end of any list desired.
	 * @param value: the value that is desired will be added to the end of the list.
	 */
	public void add(int value) {
		int[] newarraylist = new int[arraylist.length + 1];
		int j = 0;
		/**This part of the code reads through the number of elements in the list and if there is
		 and empty spot within the list, that value desired will be added to that spot.*/
		for (int i = 0; i < numOfElements + 1; i++) {
			if (i == numOfElements) {
				newarraylist[i] = value;

			}
			else {
				newarraylist[i] = arraylist[j];
				j++;
			}
		}
		numOfElements++;
		arraylist = newarraylist;
	}
	
	/**
	 * This method adds a variable at the desired index of the list.
	 * @param index: the index is where the variable desired will be inserted.
	 * @param value: the value is what will be inserted in the index that is desired.
	 */
	public void add(int index, int value) {
		int[] newarraylist = new int[arraylist.length + 1];
		int j = 0;
		/**This part of the code reads through the number of elements in the list and at the given index,
		 the program will insert the value into the desired index. */
		for (int i = 0; i < newarraylist.length; i++) {
			if (i == index) {
				newarraylist[i] = value;
			}
			else {
				newarraylist[i] = arraylist[j];
				j++;
			}
		}
		numOfElements++;
		arraylist = newarraylist;
	}
	
	/**
	 * This method reads and finds the value at a certain index. 
	 * @param index: this is the desired index to be looked at so we know what is the value at that index.
	 * @return this returns the value at a certain index of the list. 
	 */
	public int get(int index) {
		checkIndex(index, 0, numOfElements);
		return arraylist[index];
	}
	
	/**
	 * This method reads and returns the index of the first occurrence of a certain value.
	 * @param value: this is the value that is to be searched in this method
	 * @return it returns the index of which the value is in the list. 
	 */
	public int indexOf(int value) {
		for (int i = 0; i < arraylist.length; i++) {
			if (arraylist[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * This method reads and removes the value at a given index.
	 * @param index: this is the index that we want a value to be removed from the list. 
	 */
	public void remove(int index) {
		for (int i = index; i < arraylist.length - 1; i++) {
				arraylist[i] = arraylist[i + 1];
		}
		numOfElements--;
	}
	
	/**
	 * This method returns the amount of values that are in a list. 
	 * @return
	 */
	public int size() {
		int arraylistsize = numOfElements;
		return arraylistsize;
	}
	
	/**
	 * This method makes the list that we have become a string. 
	 */
	public String toString() {
		String arrayliststring = "";
		if(!isEmpty()) {
			for (int i = 0; i < numOfElements; i++) {
				if (i == 0) {
					if (this.numOfElements == 1) {
						return arrayliststring += "[" + arraylist[i] + "]";
					}
					arrayliststring += "[" + arraylist[i] + ", ";
				}	
				else if (i == numOfElements - 1) {
					arrayliststring += arraylist[i] + "]";
				}
				else {
					arrayliststring += arraylist[i] + ", ";
				}
			}
			return arrayliststring;
		}
		else if(numOfElements == arraylist.length) {
			arrayliststring = Arrays.toString(arraylist);
			return arrayliststring;
		}
		return "[]";
	}
	
	/**
	 * This method removes all of the elements from the list so that there will be values in the list. 
	 */
	public void clear() {
		arraylist = new int[arraylist.length];
		setIndex();
	}
	
	/**
	 * This method returns the whether or not a value that we want to search is there. 
	 * @param value: the value that we wish to find is in the list. 
	 * @return returns whether it is true that is there or false that it is not there. 
	 */
	public boolean contains(int value) {
		if (isEmpty()) {
			return false;
		}
		for (int i = 0; i < arraylist.length; i++) {
			if (arraylist[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method checks to see if the list can hold at least the given number of elements. 
	 * @param capacity: the capacity is used to check if the list can hold at least the capacity. 
	 */
	public void ensureCapacity(int capacity) {
		if (capacity > arraylist.length) {
			arraylist = Arrays.copyOf(arraylist, arraylist.length);

		}
	}
	
	/**
	 * This method returns whether or not a list is empty.
	 * @return returns true if the list is empty or false if the list is not empty.
	 */
	public boolean isEmpty() {
		return (numOfElements == 0);
	}
	
	/**
	 * This method checks to see if the index inputed is within the index of the list.
	 * @param index: this looks at the index that we want to look at. 
	 * @param min: this looks at the minimum index.
	 * @param max: this looks at the maximum index. 
	 * @throws IndexOutOfBoundsException: if the index that we inputed is not within the list, then
	 * a message stating that that is not possible will be presented. 
	 */
	private void checkIndex(int index, int min, int max) throws IndexOutOfBoundsException{
		if (index < min || index > max) throw new IndexOutOfBoundsException("The Index that is inputed is invalid");
	}
	
	/**
	 * This sets 
	 */
	private void setIndex() {
		numOfElements = 0;
	}
	
	/**
	 * This method gets the array list of our desired array list that will used in the SortedIntList
	 * class.
	 * @return returns the array list that we want. 
	 */
	public int[] getArrayIntList() {
		return arraylist;
	}
	
	/**
	 * This method gets the length of the array list that will be used in the SortedIntList class.
	 * @return returns the length of the array.
	 */
	public int getLength() {
		return arraylist.length;
	}
	
	/**
	 * This method checks to see if the two array lists are equal. 
	 */
	public boolean equals(Object o) {
		if (o instanceof ArrayIntList) {
			ArrayIntList otherArrayIntList = (ArrayIntList) o;
			return (otherArrayIntList.toString().equals(toString()) && otherArrayIntList.getLength() == getLength());
		}
		return false;
	}
	
}
