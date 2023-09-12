/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * Dec 10, 2022
 * PA #6
 * 
 * Most of this class was given except for the 3 problems.
 * The overall function of this Program is creating a game and being able 
 * to find a path from the top left corner to the bottom right corner while also 
 * making sure that the path for this has to have sides touching each other and cannot
 * be touching each other by corners. If you get a correct path it will light up green, but
 * if you are going in the right direction but not the correct path yet, it will highlight itself
 * and then you can reset the program and try again until you get the correct path. 
 * For Problem 1 of this PA, when you click the button “solve”, 
 * the method MazeTest.solve calls the wrapper method Maze.findMazePath(), 
 * that in turn calls your algorithm with parameters x and y set both to 0.
 * For Problem 2 of this PA, by modifying the solution of Problem 1 so that a 
 * list of all the solutions to the maze is returned. Each solution may be 
 * represented as a list of coordinates. If there are no solutions, 
 * then the resulting list should have the empty list as only element.
 * FOr Problem 3 of this PA, I have to adapt boolean Maze.findMazePath() 
 * so that it returns the shortest path in the list of paths.
 * 
 * 
 * Known Bugs:
 * There are no known bugs that I am aware of. 
 */

package Eric_HurcheyPA6;

import java.lang.module.FindException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private  TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    // COMPLETE HERE FOR PROBLEM 1
    //This part of the program checks to see if the path that is being inputed is found and holds true.
    public boolean findMazePath(int x, int y) {
    	//Checking to see if the current cell being analyzed falls outside the grid
        if (x < 0 || y < 0 || x >= maze.getNCols() || y >= maze.getNRows()) {
            return false;
        } 
        //Checking to see if the current cell being analyzed does not have NON_BACKGROUND, 
        //then false should be returned since there is no possible path through that cell.
        else if (!maze.getColor(x, y).equals(NON_BACKGROUND)) {
            return false;
        } 
        else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            maze.recolor(x, y, PATH);
            return true;
        } 
        //Checking to see if the current cell being analyzed is the exit cell, then
        //The cell must be painted color PATH. For that you may use the recolor(int x, int y, Color c)
        //method from the class TwoDimGrid, which is the type of the data field maze.
        else {
            maze.recolor(x, y, PATH);
            if (findMazePath(x - 1, y) || findMazePath(x + 1, y) || findMazePath(x, y + 1) || findMazePath(x, y -1)) {
                return true;
            } 
            else {
            	maze.recolor(x, y, TEMPORARY);
                return false;
            }
        }

    }

    // ADD METHOD FOR PROBLEM 2 HERE
    //This part of the class of the class along with the following method returns all the possible
    //paths that can be done with the path that you created.
    //This method is also a helper method
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace){
    	//Checking if (x,y) are the coordinates currently being visited
    	if (x < 0 || y < 0 || x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || (!maze.getColor(x, y).equals(NON_BACKGROUND))){
    		return;
    	} 
    	//Checking if the result is the list of successful paths recorded up to now
    	else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
    		trace.push(new PairInt(x, y));
    		ArrayList<PairInt> currentTrace = new ArrayList<>(trace); 
    		result.add(currentTrace);
    		trace.pop();
    		maze.recolor(x, y, NON_BACKGROUND);
    		return;
    	} 
    	//Checking if trace is the trace of the current path being explored
    	else {
    		trace.push(new PairInt(x, y)); 
			maze.recolor(x, y, PATH); 
			findMazePathStackBased(x, y + 1, result, trace);
			findMazePathStackBased(x, y - 1, result, trace);
			findMazePathStackBased(x + 1, y, result, trace);
			findMazePathStackBased(x - 1, y, result, trace);
			maze.recolor(x, y, NON_BACKGROUND);
			trace.pop();
			return;
    	}
    }
    
    //This method was given
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
    	ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
    	Stack<PairInt> trace = new Stack<>();
    	findMazePathStackBased(0, 0, result, trace);
    	return result;
    }

    // ADD METHOD FOR PROBLEM 3 HERE
    //This part of the method integrates the previous method and returns the 
    //shortest path in the list of paths.
    public ArrayList<PairInt> findMazePathMin(int x, int y) {
    	//local variables for this method
    	int index = 0;
    	int[] count;
    	int minimum;
    	ArrayList<ArrayList<PairInt>> allPossiblePaths;
    	allPossiblePaths = findAllMazePaths(x, y);
    	count = new int[allPossiblePaths.size()];
    	//for loop for looking at the size of all possible paths and counting it
    	for (int i = 0; i < allPossiblePaths.size(); i++) {
    		count[i] = allPossiblePaths.get(i).size();
    	}
    	minimum = count[0];
    	//a for loop to give back the shortest possible path 
    	for (int i = 1; i < count.length; i++) {
    		if (count[i] < minimum) {
    			minimum = count[i];
    			index = i;
    		}
    	}
    	return allPossiblePaths.get(index);
    }    

    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }

    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
}
