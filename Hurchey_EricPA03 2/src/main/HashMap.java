/**
 * This class is a data structure that allows you to add items, and then test if 
 * they are elements of the heap.
 * Known Bugs: None that I know of
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * Due May 09, 2023
 * COSI 21A PA03
 */

package main;

public class HashMap {
	
	//These are the fields that I used for this class

	private static final int INITIAL_CAPACITY = 97;
	private static final double LOAD_FACTOR_THRESHOLD = 0.75;
	private Entry[] table;
    private int size;
	
    //This are the methods that are implemented in this class
    
	public HashMap() {
		this.table = new Entry[INITIAL_CAPACITY];
        this.size = 0;
	}
	
	public void set(GraphNode key, int value) {
		if ((double) size / table.length > LOAD_FACTOR_THRESHOLD) {
            rehash();
        }
        int index = getIndex(key);
        Entry entry = table[index];
        while (entry != null && !entry.getKey().equals(key)) {
            index = (index + 1) % table.length;
            entry = table[index];
        }
        if (entry != null) {
            entry.setValue(value);
        } else {
            table[index] = new Entry(key, value);
            size++;
        }
    }
	
	public int getValue(GraphNode key) {
        int index = getIndex(key);
        Entry entry = table[index];
        while (entry != null && !entry.getKey().equals(key)) {
            index = (index + 1) % table.length;
            entry = table[index];
        }
        if (entry != null) {
            return entry.getValue();
        } else {
            throw new IllegalArgumentException("Key not found.");
        }
    }
	
	public boolean hasKey(GraphNode key) {
        int index = getIndex(key);
        Entry entry = table[index];
        while (entry != null && !entry.getKey().equals(key)) {
            index = (index + 1) % table.length;
            entry = table[index];
        }
        return entry != null;
    }

	
	//These following methods are helper methods
	
	/**
	 * This method will get the index of a key in the hash map
	 * @param key <- the desired key
	 * @return the desired index 
	 */
    private int getIndex(GraphNode key) {
        return Math.abs(key.getId().hashCode() % table.length);
    }
    
    /**
     * This method will rehash the table if needed
     */
    private void rehash() {
        Entry[] oldTable = table;
        table = new Entry[2 * oldTable.length];
        size = 0;
        for (Entry entry : oldTable) {
            if (entry != null) {
                set(entry.getKey(), entry.getValue());
            }
        }
    }
}
