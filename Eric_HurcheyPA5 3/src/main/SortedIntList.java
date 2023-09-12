/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * Nov 27, 2022
 * PA #5
 * 
 * This SortedIntList class creates a list of integers but has a unique value to check later on
 * if there are duplicates and if there are duplicates for those duplicates to be removed and also 
 * creating a list of integers that are in order. 
 * 
 * Known Bugs:
 * There are no known bugs currently that I know of.
 */

package main;

import java.util.*;

public class SortedIntList extends ArrayIntList {

	/**
	 * These are the variables that I used throughout this class.
	 */
	private static final boolean setUnique = false;
	private boolean inputUnique;
	
	/**
	 * This method creates an empty list from the ArrayIntList class with a default size of 10 
	 * and sets the integers in this list to a unique value. 
	 */
	public SortedIntList() {
		super();
		setUnique(setUnique);
		return;
	}
	
	/**
	 * This method uses the list created in the other class and sets a unique value to each 
	 * of those integers being created. 
	 * @param unique: setting the integers in the list to a unique value. 
	 */
	public SortedIntList(boolean unique) {
		super();
		setUnique(unique);
		return;
	}
	
	/**
	 * This method constructs a list using the list from the other method and allowing duplicates.
	 * @param capacity: this the size of the list
	 */
	public SortedIntList(int capacity) {
		super(capacity);
		setUnique(inputUnique);
		return;
	}
	
	/**
	 * This method constructs a list using the list from the other method and setting the integers
	 * to a unique value.
	 * @param unique: this is the unique value that is being set to each of those integers in the list.
	 * @param capacity: this is the size of the list being set.
	 */
	public SortedIntList(boolean unique, int capacity) {
		super(capacity);
		setUnique(unique);
		return;
	}
	
	/**
	 * This method adds the desired value to the list while also maintaining the list in order.
	 */
	public void add (int value) {
		int desiredindex = indexOf(value);
		if (desiredindex > 0) {
    		if (!getUnique()) {
    			super.add(desiredindex, value);
    		}
    	}
    	else if (desiredindex == 0) {
    		super.add (desiredindex, value);
    	}
    	else super.add (- 1 * desiredindex, value);
	}
	
	/**
	 * This method always throws an UnsupportedOperationException.
	 */
	public void add (int index, int value) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("This is not possible");
	}
	
	/**
	 * This method returns the unique value for a certain index for the list. 
	 * @return 
	 */
	public boolean getUnique() {
		return inputUnique;
	}
	
	/**
	 * This method returns whether only unique values are allowed in the list but optimized.
	 */
	public int indexOf(int value) {
		int[] inputArrayList = super.getArrayIntList();
		int inputindex = Arrays.binarySearch(inputArrayList, 0, super.size(), value);
		if (inputindex > 0) {
			return inputindex;
		}
		return inputindex + 1;
	}
	
	/**
	 * This method gives the maximum integer in a list.
	 * @return
	 * @throws NoSuchElementException: if the list is empty. 
	 */
	public int max() throws NoSuchElementException{
		int[] inputArrayList = super.getArrayIntList();
		if (super.size() == 0) {
			throw new NoSuchElementException();
		}
		int numOfElements = super.size();
		if (numOfElements == 1) {
			return inputArrayList[0];
		}
		for (int i = 1; i < numOfElements; i++) {
			if (inputArrayList[i] < inputArrayList[i - 1]) {
				inputArrayList[i] = inputArrayList[i - 1];
			}
		}
		return inputArrayList[numOfElements - 1];
		
	}
	
	/**
	 * This method gives the minimum integer in a list. 
	 * @return
	 * @throws NoSuchElementException: if the list is empty. 
	 */
	public int min() throws NoSuchElementException{
		int[] inputArrayList = super.getArrayIntList();
		if (super.size() == 0) {
			throw new NoSuchElementException();
		}
		int numOfElements = super.size();
		if (numOfElements == 1) {
			return inputArrayList[0];
		}
		for (int i = 1; i < numOfElements; i++) {
			if (inputArrayList[i] > inputArrayList[i - 1]) {
				inputArrayList[i] = inputArrayList[i - 1];
			}
		}
		return inputArrayList[numOfElements - 1];
	}
	
	/**
	 * This method sets whether only unique values are allowed in the list; 
	 * if set to true, immediately removes any existing duplicates from the list.
	 * @param unique
	 */
	public void setUnique(boolean unique) {
		int[] inputArrayList = super.getArrayIntList();
		boolean originalUnique = inputUnique;
		int numOfElements = super.size();
		inputUnique = unique; 
		if (originalUnique == false && inputUnique == true) {
			if (numOfElements > 1) {
				for (int i = 0; i < super.size() - 1; i++) {
					if (inputArrayList[i] == inputArrayList[i + 1]) {
						super.remove(i--);
					}
				}
			}
		}
	}
	
	/**
	 * This method sets the sorted list to a string
	 */
	public String toString() {
		String arrayliststring = "S: ";
		arrayliststring += super.toString();
		if (inputUnique) {
			arrayliststring += "U";
		}
		return arrayliststring;
	}
		
	/**
	 * This method returns whether or not two different SortIntLists are equal such as its length
	 * and unique value. 
	 */
	public boolean equals(Object o) {
		if (o instanceof SortedIntList) {
			SortedIntList otherSortedIntList = (SortedIntList) o;
			return (otherSortedIntList.toString().equals(toString()) && otherSortedIntList.getLength() == getLength());
		}
		return false;
	}
}
