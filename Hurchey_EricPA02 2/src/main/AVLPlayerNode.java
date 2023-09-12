/**
 * The class helps run the ScoreKeeper class. It creates nodes of my AVL tree. 
 * Each node will have a left child, a right child, and a Player object, a double 
 * balance factor for AVL balancing, number of nodes in the right subtree. It is able to go left or 
 * right of the AVL tree and then go left or right to those children. It is also able to get 
 * the ranks and the players of the desired people. This class also serves as a purpose to be able to
 * set those values into a string. 
 * Known Bugs: There is a slight error with my treeString method. While the idea and consensus is right,
 * it returns a slight disorientated tree. 
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * Due April 04, 2023
 * COSI 21A PA2
 */

package main;

/**
 * Your code goes in this file
 * fill in the empty methods to allow for the required
 * operations. You can add any fields or methods you want
 * to help in your implementations.
 */

public class AVLPlayerNode{
    private Player data;
    private double value;
    private AVLPlayerNode parent;
    private AVLPlayerNode leftChild;
    private AVLPlayerNode rightChild;
    private int rightWeight;
    private int balanceFactor;
    
    /**
     * This method initializes the fields that I will implement later in this class
     * @param data the player being inputed
     * @param value the player's ID being inputed
     */
    public AVLPlayerNode(Player data,double value){
        this.data = data;
        this.value = value;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.rightWeight = 0;
        this.balanceFactor = 0;
    }
    
    /**
     * This method is able to insert a new player whenever, whether it is at the beginning of the code
     * or when the player calls for adding a new player.
     * @param newGuy an inputed new player
     * @param value an inputed new value
     * @return the current node
     * Running Time: 
     */
    //This should return the new root of the tree
    //make sure to update the balance factor and right weight
    //and use rotations to maintain AVL condition
    public AVLPlayerNode insert(Player newGuy,double value){
    	AVLPlayerNode newNode = new AVLPlayerNode(newGuy, value);
        AVLPlayerNode curNode = this;
        if (this.data == null) {
            // If the current node is the root node, then set the data of the root node
            this.data = newGuy;
            this.value = value;
            return this;
        }
        while (true) {
            if (newNode.value < curNode.value) {
                // Insert the new node in the left subtree
                if (curNode.leftChild == null) {
                    curNode.leftChild = newNode;
                    newNode.parent = curNode;
                    curNode.balanceFactor--;
                    curNode.rightWeight++;
                    break;
                }
                curNode = curNode.leftChild;
            } else {
                // Insert the new node in the right subtree
                if (curNode.rightChild == null) {
                    curNode.rightChild = newNode;
                    newNode.parent = curNode;
                    curNode.balanceFactor++;
                    curNode.rightWeight++;
                    break;
                }
                curNode = curNode.rightChild;
            }
        }
        // Rebalance the tree if needed
        if (curNode.balanceFactor == 2) {
            if (curNode.rightChild.balanceFactor == -1) {
                curNode.rightChild.rotateRight();
            }
            curNode.rotateLeft();
        } else if (curNode.balanceFactor == -2) {
            if (curNode.leftChild.balanceFactor == 1) {
                curNode.leftChild.rotateLeft();
            }
            curNode.rotateRight();
        }
        // Update the root node if necessary
        while (curNode.parent != null) {
            curNode = curNode.parent;
        }
        return curNode;
    }
    
    /**
     * This method implements the delete method where you delete a desired person in the 
     * ScoreKeeper class
     * @param value the input ID being deleted
     * @return the now redone tree
     * Running Time: O(log n)
     */
    //This should return the new root of the tree
    //remember to update the right weight
    public AVLPlayerNode delete(double value){
	//TODO: write standard vanilla BST delete method
    //Extra Credit: use rotations to maintain the AVL condition
    	AVLPlayerNode nodeToDelete = findNode(value);
    	// value not found in tree
        if (nodeToDelete == null) {
            return this;
        }
        AVLPlayerNode parentToDelete = nodeToDelete.parent;
        // Case 1: node has no children
        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
        	// node is root and only node in tree
        	if (parentToDelete == null) {
                return null; 
            } 
        	else {
                if (parentToDelete.leftChild == nodeToDelete) {
                    parentToDelete.leftChild = null;
                    parentToDelete.rightWeight--;
                } 
                else {
                    parentToDelete.rightChild = null;
                    parentToDelete.rightWeight--;
                }
            }
        }
        // Case 2: node has one child
        else if (nodeToDelete.leftChild == null || nodeToDelete.rightChild == null) {
            AVLPlayerNode child;
            if (nodeToDelete.leftChild != null) {
                child = nodeToDelete.leftChild;
            } 
            else {
                child = nodeToDelete.rightChild;
            }
            if (parentToDelete == null) {
                child.parent = null;
                return child;
            } 
            else {
                child.parent = parentToDelete;
                if (parentToDelete.leftChild == nodeToDelete) {
                    parentToDelete.leftChild = child;
                } 
                else {
                    parentToDelete.rightChild = child;
                    parentToDelete.rightWeight--;
                }
            }
        }
        // Case 3: node has two children
        else {
            AVLPlayerNode successor = findSuccessor(nodeToDelete);
            nodeToDelete.data = successor.data;
            nodeToDelete.value = successor.value;
            AVLPlayerNode parentOfSuccessor = successor.parent;
            if (parentOfSuccessor.leftChild == successor) {
                parentOfSuccessor.leftChild = successor.rightChild;
                if (successor.rightChild != null) {
                    successor.rightChild.parent = parentOfSuccessor;
                }
            } 
            else {
                parentOfSuccessor.rightChild = successor.rightChild;
                if (successor.rightChild != null) {
                    successor.rightChild.parent = parentOfSuccessor;
                }
            }
            parentToDelete = parentOfSuccessor;
            while (parentToDelete != null) {
                if (parentToDelete.leftChild != null) {
                    parentToDelete.balanceFactor = parentToDelete.leftChild.rightWeight - parentToDelete.leftChild.getWeight();
                } 
                else {
                    parentToDelete.balanceFactor = -parentToDelete.rightWeight;
                }
                if (parentToDelete.balanceFactor == -2) {
                    if (parentToDelete.rightChild.rightChild != null && parentToDelete.rightChild.leftChild != null && parentToDelete.rightChild.rightChild.balanceFactor == 1) {
                        parentToDelete.rightChild.rotateRight();
                    }
                    parentToDelete.rotateLeft();
                } 
                else if (parentToDelete.balanceFactor == 2) {
                    if (parentToDelete.leftChild.leftChild != null && parentToDelete.leftChild.rightChild != null && parentToDelete.leftChild.leftChild.balanceFactor == -1) {
                        parentToDelete.leftChild.rotateLeft();
                    }
                    parent.rotateRight();
                }
                // tree is balanced
                if (parentToDelete.balanceFactor == 0) {
                    break;
                }
                parentToDelete = parentToDelete.parent;
            }
        }
        return this;
    }
    
    /**
     * This method, while maintaining rightWeight, rotates the tree to the right.
     * Running Time: O(1)
     */
    //remember to maintain rightWeight
    private void rotateRight(){
    	AVLPlayerNode newRoot = this.leftChild;
        AVLPlayerNode parentNode = this.parent;
        //Case 1
        if (newRoot.rightChild != null) {
            newRoot.rightChild.parent = this;
            this.leftChild = newRoot.rightChild;
        } 
        else {
            this.leftChild = null;
        }
        newRoot.rightChild = this;
        this.parent = newRoot;
        //Case 2
        if (parent != null) {
            if (parentNode.leftChild == this) {
                parentNode.leftChild = newRoot;
            } 
            else {
                parentNode.rightChild = newRoot;
            }
        }
        newRoot.parent = parentNode;
        if(newRoot.balanceFactor > 0) {
        	this.balanceFactor = this.balanceFactor + 1 - newRoot.balanceFactor;
        }
        else if(newRoot.balanceFactor < 0) {
        	this.balanceFactor = this.balanceFactor + 1 - 0;
        }
        if(this.balanceFactor > 0){
        	newRoot.balanceFactor = newRoot.balanceFactor + 1 + this.balanceFactor;
        }
        else if(this.balanceFactor < 0) {
        	newRoot.balanceFactor = newRoot.balanceFactor + 1 + 0;
        }
        this.rightWeight = this.rightWeight - newRoot.rightWeight - 1;
        newRoot.rightWeight = newRoot.rightWeight + this.rightWeight + 1;
    }

    /**
     * This method, while maintaining rightWeight, rotates the tree to the left.
     * Running Time: O(log n)
     */
    //remember to maintain rightWeight
    private void rotateLeft(){
    	AVLPlayerNode newRoot = rightChild;
        newRoot.parent = parent;
        //Case 1
        if (newRoot.parent != null) {
            if (newRoot.parent.leftChild == this) {
                newRoot.parent.leftChild = newRoot;
            } 
            else {
                newRoot.parent.rightChild = newRoot;
            }
        }
        rightChild = newRoot.leftChild;
        //Case 2
        if (rightChild != null) {
            rightChild.parent = this;
        }
        newRoot.leftChild = this;
        parent = newRoot;
        //Case 3
        if (newRoot.leftChild == null && newRoot.rightChild != null) {
            rightWeight = newRoot.rightChild.rightWeight + 1;
        //Case 4
        } 
        else if (newRoot.leftChild != null && newRoot.rightChild == null) {
            rightWeight = newRoot.leftChild.rightWeight + 1;
        //Case 5
        } 
        else if (newRoot.leftChild != null && newRoot.rightChild != null) {
        	if(newRoot.leftChild.rightWeight > newRoot.rightChild.rightWeight) {
        		rightWeight = newRoot.leftChild.rightWeight + 1;
        	}
        	else if(newRoot.leftChild.rightWeight < newRoot.rightChild.rightWeight) {
        		rightWeight = newRoot.rightChild.rightWeight + 1;
        	}
        } 
        else {
            rightWeight = 0;
        }
        newRoot.balanceFactor += 1;
        balanceFactor -= 1;
    }
    
    /**
     * This method gets the desired player based on the ID
     * @param value the inputed ID
     * @return the desired player 
     * Running Time: O(n) 
     */
    //this should return the Player object stored in the node with this.value == value
    public Player getPlayer(double value){
    	if (this.value == value) {
            return this.data;
        } 
    	else if (value < this.value && this.leftChild != null) {
            return this.leftChild.getPlayer(value);
        } 
    	else if (value > this.value && this.rightChild != null) {
            return this.rightChild.getPlayer(value);
        } 
    	else {
            return null;
        }
    }
    
    /**
     * This methods gets the Rank of the desired player
     * @param value the desired player's ID
     * @return the player's rank
     * Running Time: O(log n) when the tree is balanced
     * Worse Case: O(n) when the tree is unbalanced
     */
    //this should return the rank of the node with this.value == value
    public int getRank(double value){
    	int rank = 1;
        AVLPlayerNode currNode = this;

        while (currNode != null) {
            if (value == currNode.value) {
                // Found the node with the given value
                if (currNode.leftChild != null) {
                    // Add the rank of the largest value in the left subtree
                    rank += currNode.leftChild.rightWeight + 1;
                }
                return rank;
            } 
            else if (value < currNode.value) {
                // The value must be in the left subtree
                currNode = currNode.leftChild;
            } 
            else {
                // The value must be in the right subtree
                if (currNode.leftChild != null) {
                    // Add the rank of the largest value in the left subtree
                    rank += currNode.leftChild.rightWeight + 1;
                }
                rank++;
                currNode = currNode.rightChild;
            }
        }
        // The value was not found in the tree
        return -1;
    }
    
    /**
     * This methods returns the AVL tree into a string
     * @return AVL tree string
     * Running Time: O(n)
     */
    //this should return the tree of names with parentheses separating subtrees
    //eg "((bob)alice(bill))"
    public String treeString(){
    	StringBuilder treeString = new StringBuilder();
        treeString.append("(");
        if (leftChild != null) {
        	treeString.append(leftChild.treeString());
        }
        treeString.append(data.getName());
        if (rightChild != null) {
        	treeString.append(rightChild.treeString());
        }
        treeString.append(")");
        return treeString.toString();
    }

    /**
     * This method returns the values of the game into a scoreboard where it is written out as a string
     * @return the scoreboard into a string
     * Running Time: O(n)
     */
    //this should return a formatted scoreboard in descending order of value
    //see example printout in the pdf for the command L
    public String scoreboard(){
    	StringBuilder scoreboardString = new StringBuilder();
        AVLPlayerNode currentNode = this;
        while (currentNode.rightChild != null) {
            currentNode = currentNode.rightChild;
        }
        scoreboardString.append("NAME").append("\tID").append(" ").append("SCORE").append("\n");
        while (currentNode != null) {
        	scoreboardString.append(currentNode.data.getName()).append("\t").append(currentNode.data.getID()).append(" ").append(currentNode.data.getELO()).append("\n");
            if (currentNode.leftChild != null) {
                currentNode = currentNode.leftChild;
                while (currentNode.rightChild != null) {
                    currentNode = currentNode.rightChild;
                }
            } 
            else {
                AVLPlayerNode parentNode = currentNode.parent;
                while (parentNode != null && currentNode == parentNode.leftChild) {
                    currentNode = parentNode;
                    parentNode = parentNode.parent;
                }
                currentNode = parentNode;
            }
        }
        return scoreboardString.toString();
    }
    
    
    
    
    /**These are the list of Helper Methods that make the other methods run*/
    
    /**
     * Start of Helper Methods
     */
    
    /**
     * This method gets the height of desired left or right side of the AVL tree
     * @return the desired height
     * Running Time: O(n)
     */
    public int getHeight() {
        int leftHeight = 0;
        int rightHeight = 0;
        if (leftChild != null) {
            leftHeight = leftChild.getHeight();
        }
        if (rightChild != null) {
            rightHeight = rightChild.getHeight();
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    /**
     * This method finds the desired ID node to help the other methods above
     * @param value the ID node
     * @return the desired node
     * Running Time: O(log n)
     * Worst Case: O(n)
     * Best Case: O(1)
     */
    private AVLPlayerNode findNode(double value) {
        AVLPlayerNode currentNode = this;
        while (currentNode != null) {
            if (value == currentNode.value) {
                return currentNode;
            } 
            else if (value < currentNode.value) {
                currentNode = currentNode.leftChild;
            } 
            else {
                currentNode = currentNode.rightChild;
            }
        }
        return null;
    }

    /**
     * This method finds the Successor of an inputed node in the other methods above
     * @param node the node that you want to find the successor to the desired node
     * @return 
     * Running Time: O(log n)
     * Worst Case: O(n)
     */
    private AVLPlayerNode findSuccessor(AVLPlayerNode node) {
        if (node.rightChild == null) {
            AVLPlayerNode parentNode = node.parent;
            while (parentNode != null && node == parentNode.rightChild) {
                node = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        } 
        else {
            AVLPlayerNode currentNode = node.rightChild;
            while (currentNode.leftChild != null) {
                currentNode = currentNode.leftChild;
            }
            return currentNode;
        }
    }

    /**
     * This method gets the Weight
     * @return the weight
     * Running Time: O(1)
     */
    private int getWeight() {
        return this.rightWeight + 1;
    }

	/**
	 * End of Helper Methods
	 */
    
    
    
    
    /**These following methods are get helper methods to help test this class*/
    
    /**
     * Start
     */
    
    /**
     * This method gets the Data/Player
     * @return the data/player
     * Running Time: O(1)
     */
    public Player getData() {
        return this.data;
    }

    /**
     * This method gets the Value
     * @return the value 
     * Running Time: O(1)
     */
    public double getValue() {
        return this.value;
    }
    
    /**
     * This method gets the Left Child
     * @return the left child
     * Running Time: O(1)
     */
    public AVLPlayerNode getLeftChild() {
        return this.leftChild;
    }

    /**
     * This method gets the Right Child
     * @return the right child
     * Running Time: O(1)
     */
    public AVLPlayerNode getRightChild() {
        return this.rightChild;
    }

    /**
     * This method gets the Balance Factor
     * @return the balance factor
     * Running Time: O(1)
     */
    public int getBalanceFactor() {
    	return this.balanceFactor;
    }
    /**
     * End
     */
}
