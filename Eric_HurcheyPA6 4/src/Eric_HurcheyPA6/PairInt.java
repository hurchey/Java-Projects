/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * Dec 10, 2022
 * PA #6
 * 
 * This class is a continuation of Problem 2 where this class defines and encodes pairs of integers that 
 * represent coordinates
 * 
 * Known Bugs:
 * There are no known bugs that I am aware of. 
 */

package Eric_HurcheyPA6;

public class PairInt {
	
	//variables used for this class
    private int x;
    private int y;

    //this is a constructor method for the coordinates
    public PairInt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //this is a getter method of the X coordinates
    public int getX() {
        return x;
    }

    //this is a getter method of the Y coordinates
    public int getY() {
        return y;
    }

    //this is a setter method of X to set X back to the original if needed
    public void setX(int x) {
        this.x = x;
    }

    //this is a setter method of Y to set Y back to the original if needed
    public void setY(int y) {
        this.y = y;
    }

    //this method just checks if the coordinates are equal
    @Override
    public boolean equals(Object p) {
        if (p == null) {
            return false;
        }
        PairInt pairInt = (PairInt) p;
        return (this.x == pairInt.x && this.y == pairInt.y);
    }

    //this method sets the coordinates into a string
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    //this method creates a new copy of PairInt
    public PairInt copy() {
        return new PairInt(x, y);
    }
}