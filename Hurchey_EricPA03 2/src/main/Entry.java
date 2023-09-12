/**
 * This class, which has a key and a value, stores keys and values together which then 
 * my hash map can store an array of Entry objects.
 * Known Bugs: None that I know of
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * Due May 09, 2023
 * COSI 21A PA03
 */

package main;

public class Entry {
	
	//These are fields that I used for this class
	
    private GraphNode key;
    private int value;

    /**
     * A key entering the hash map
     * @param key <- inputed key
     * @param value <- inputed value
     */
    public Entry(GraphNode key, int value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the desired key
     * @return the desired key
     */
    public GraphNode getKey() {
        return key;
    }

    /**
     * Gets the desired value
     * @return the desired value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the desired value
     * @param value <- inputs the desired value
     */
    public void setValue(int value) {
        this.value = value;
    }
}

