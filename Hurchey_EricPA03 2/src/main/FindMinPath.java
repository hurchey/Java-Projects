/**
 * In this class is where the main algorithm for finding the shortest path to the internship
 * can be found.
 * Known Bugs: None that I know of
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * Due May 09, 2023
 * COSI 21A PA03
 */

package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FindMinPath {

	//Main Function
	
    public static void main(String[] args) {
        GraphWrapper gw = new GraphWrapper();
        GraphNode home = gw.getHome();
        HashMap hashMap = new HashMap();
        GraphNode goal = null;
        GraphNode curr = null;
        
        // 1. Create a priority queue Q
        MinPriorityQueue Q = new MinPriorityQueue();

        // 2. Get the GraphNode for your home, and set its priority to 0
        if (home != null) {
            // initialize home priority to 0 and insert into the priority queue
            home.priority = 0;
            Q.insert(home);
        } else {
            System.out.println("Error: could not find starting node.");
        }

        // 3. while Q is not empty and you haven't found your goal yet:
        while (!Q.isEmpty() && goal == null) {
            // a. GraphNode curr = Q.pullHighestPriorityElement()
            curr = Q.pullHighestPriorityElement();
            hashMap.set(curr, 5);
            
            // b. if curr.isGoalNode() - then we found the goal (save this as answer)
            if (curr.isGoalNode()) {
                goal = curr;
            }

            // c. else: for each neighbor of curr that you can access (use the hasNorth, hasSouth, etc. methods)
            else {
	            if (curr.hasNorth()) {
	            	if(!hashMap.hasKey(curr.getNorth())) {
		                GraphNode neighbor = curr.getNorth();
		                int x = curr.priority + curr.getNorthWeight();
		                processNeighbor(Q, curr, neighbor, x, "North");
	            	}
	            }
	            if (curr.hasSouth()) {
	            	if(!hashMap.hasKey(curr.getSouth())) {
		                GraphNode neighbor = curr.getSouth();
		                int x = curr.priority + curr.getSouthWeight();
		                processNeighbor(Q, curr, neighbor, x, "South");
	            	}
	            }
	            if (curr.hasWest()) {
	            	if(!hashMap.hasKey(curr.getWest())) {
		                GraphNode neighbor = curr.getWest();
		                int x = curr.priority + curr.getWestWeight();
		                processNeighbor(Q, curr, neighbor, x, "West");
	            	}
	            }
	            if (curr.hasEast()) {
	            	if(!hashMap.hasKey(curr.getEast())) {
		                GraphNode neighbor = curr.getEast();
		                int x = curr.priority + curr.getEastWeight();
		                processNeighbor(Q, curr, neighbor, x, "East");
	            	}
	            }
            }
        }

        if (goal != null) {
            // print out the path from start to goal
            StringBuilder answerPath = new StringBuilder();
            curr = goal;
            while (curr != home) {
            	answerPath.insert(0, curr.previousDirection + "\n");
                curr = curr.previousNode;
            }
            answerPath.insert(0, "Path from home to goal:\n");
            System.out.println(answerPath.toString());
            //This will print the answer in the console and the later code will print the 
            //answer in a txt file

            // write the path to a file
            File answerFile = new File("answer.txt");
            try (FileWriter answerWriter = new FileWriter(answerFile)) {
                answerWriter.write(answerPath.toString());
                System.out.println("Path written to file: " + answerFile.getPath());
                //This checks to make sure that a txt file was created and that the answer
                //appears in the file
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
                //In case there is an error when trying to print the txt file
            }
        } else {
            System.out.println("No path found from home to goal.");
            //If there is no path found
        }
    }
    
    
    //This is a helper method that is used to complete the rest of the main function needs to do. 
    
    /**
     * This method carries out the Dijkstra's search method
     * @param Q calls for the MinPriorityQueue
     * @param curr calls for the current GraphNode
     * @param neighbor calls for the neighbor of the current GraphNode
     * @param x calls for the value of the current priority and the direction weight
     * @param dir the desired direction in the form of a string
     */
    private static void processNeighbor(MinPriorityQueue Q, GraphNode curr, GraphNode neighbor, int x, String dir) {
        if (!Q.contains(neighbor)) {
            // if neighbor is not in the priority queue, make neighbor.priority = x,
            // neighbor.previousNode=curr, neighbor.previousDirection=[the direction you came in],
            // and add it to the priority queue.
            neighbor.priority = x;
            neighbor.previousNode = curr;
            neighbor.previousDirection = dir;
            Q.insert(neighbor);
        } else if (x < neighbor.priority) {
            // if neighbor is in the priority queue but x is less than the priority of neighbor,
            // then make neighbor.priority = x, re-heapify the priority queue,
            // and make neighbor.previousNode = curr, neighbor.previousDirection=[the direction you came in.
            neighbor.priority = x;
            neighbor.previousNode = curr;
            neighbor.previousDirection = dir;
            Q.decreasePriorityQueue(neighbor);
        }
    }

}
