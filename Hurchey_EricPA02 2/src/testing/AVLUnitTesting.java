/**
  * A JUnit Class testing the AVLPlayerNode Class
  * Known Bugs: None, not that I am aware of. 
  *
  * @author Eric Hurchey 
  * erichurchey@brandeis.edu
  * Due April 04, 2023
  * COSI 21A PA2
  */

package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.AVLPlayerNode;
import main.Player;

class AVLUnitTesting {

	/**
	 * This method tests the insert method 
	 */
	@Test
    void testInsert() {
		AVLPlayerNode root = new AVLPlayerNode(null, 0);
	    
	    Player p1 = new Player("Eric", 1, 3000);
	    Player p2 = new Player("Grace", 2, 2000);
	    Player p3 = new Player("Ming", 3, 4000);

	    root = root.insert(p1, p1.getELO());
	    root = root.insert(p2, p2.getELO());
	    root = root.insert(p3, p3.getELO());
	    
	    assertEquals("Eric", root.getData().getName());
	    assertEquals(1, root.getData().getID());
	    assertEquals(3000, root.getValue());

	    assertEquals("Grace", root.getLeftChild().getData().getName());
	    assertEquals(2, root.getLeftChild().getData().getID());
	    assertEquals(2000, root.getLeftChild().getValue());

	    assertEquals("Ming", root.getRightChild().getData().getName());
	    assertEquals(3, root.getRightChild().getData().getID());
	    assertEquals(4000, root.getRightChild().getValue());
	}
	
	/**
	 * This method tests the delete method
	 */
	@Test
	void testDelete(){
		AVLPlayerNode root = new AVLPlayerNode(null, 0);

	    Player p1 = new Player("Eric", 1, 3000);
	    Player p2 = new Player("Ming", 2, 2000);
	    Player p3 = new Player("Grace", 3, 4000);
	    Player p4 = new Player("Paul", 4, 1000);

	    root.insert(p1, p1.getID());
	    root.insert(p2, p2.getID());
	    root.insert(p3, p3.getID());
	    root.insert(p4, p4.getID());

	    // Delete a player from the tree
	    root = root.delete(p2.getID());

	    // Check that the deleted player is no longer in the tree
	    assertEquals(null, root.getRightChild().getLeftChild());
	}
	
	/**
	 * This method tests the getRank method
	 */
	@Test
    public void testGetRank() {
        AVLPlayerNode root = new AVLPlayerNode(null, 0);
        
        Player p1 = new Player("Eric", 1, 3000);
        Player p2 = new Player("Grace", 2, 2000);
        Player p3 = new Player("Ming", 3, 4000);
        Player p4 = new Player("Paul", 4, 1000);
        
        root.insert(p1, p1.getID());
        root.insert(p2, p2.getID());
        root.insert(p3, p3.getID());
        root.insert(p4, p4.getID());
        
        assertEquals(4, root.getRank(p4.getID()));
        assertEquals(3, root.getRank(p3.getID()));
        assertEquals(2, root.getRank(p2.getID()));
        assertEquals(1, root.getRank(p1.getID()));
    }
	
	/**
	 * This method tests the getPlayer method
	 */
	@Test
    public void testGetPlayer() {
		Player p1 = new Player("Eric", 1, 3000);
        Player p2 = new Player("Grace", 2, 2000);
        Player p3 = new Player("Ming", 3, 4000);
        Player p4 = new Player("Paul", 4, 1000);

        assertEquals("Eric", p1.getName());
        assertEquals(1, p1.getID());
        assertEquals(3000, p1.getELO());

        assertEquals("Grace", p2.getName());
        assertEquals(2, p2.getID());
        assertEquals(2000, p2.getELO());

        assertEquals("Ming", p3.getName());
        assertEquals(3, p3.getID());
        assertEquals(4000, p3.getELO());

        assertEquals("Paul", p4.getName());
        assertEquals(4, p4.getID());
        assertEquals(1000, p4.getELO());

    }
	
	/**
	 * This method tests the tree toString method
	 */
	@Test
	public void testTreeString() {
		AVLPlayerNode root = new AVLPlayerNode(null, 0);

	    Player p1 = new Player("Eric", 1, 3000);
	    Player p2 = new Player("Grace", 2, 2000);
	    Player p3 = new Player("Ming", 3, 4000);
	    Player p4 = new Player("Paul", 4, 1000);

	    root.insert(p1, p1.getID());
	    root.insert(p2, p2.getID());
	    root.insert(p3, p3.getID());
	    root.insert(p4, p4.getID());


	    assertEquals("(Eric(Grace(Ming(Paul))))", root.treeString());
	}
	
	/**
	 * This method tests the scoreboard toString method
	 */
	@Test
	public void testScoreboardString() {
	    AVLPlayerNode root = new AVLPlayerNode(null, 0);
	        
	    Player p1 = new Player("Eric", 1, 3000);
	    Player p2 = new Player("Paul", 2, 2000);
	    Player p3 = new Player("Ming", 3, 4000);
	    Player p4 = new Player("Grace", 4, 1000);
	        
	    root.insert(p1, p1.getELO());
	    root.insert(p2, p2.getELO());
	    root.insert(p3, p3.getELO());
	    root.insert(p4, p4.getELO());
	    
	    String expectedScoreboard = "NAME\tID SCORE\n" + "Ming\t3 4000.0\n" + "Eric\t1 3000.0\n" + "Paul\t2 2000.0\n" + "Grace\t4 1000.0\n";
	    
	    assertEquals(expectedScoreboard, root.scoreboard());
	}

}
