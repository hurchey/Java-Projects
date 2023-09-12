/**
* This class provides the implementation of a doubly linked list node. 
* These nodes have a pointer to the next node, a pointer to the previous node, and data.
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package main;

public class Node<T> {
	
	public T data;
	public Node <T> prev;
	public Node <T> next;
	
	/**This method will construct a doubly linked list node 
	 * that holds a data field but does not point to any other nodes.
	 * Running Time: O(1)*/
	public Node(T data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	
	/**This method will set the data field of this node.
	 * Running Time: O(1)*/
	public void setData(T data) {
		this.data = data;
	}
	
	/**This method will set the next pointer of this node.
	 * Running Time: O(1)*/
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**This method will set the previous pointer of this node.
	 * Running Time: O(1)*/
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	/**This method will return the data stored in this node.
	 * Running Time: O(1)*/
	public T getData() {
		return this.data;
	}
	
	/**This method will return the pointer to the next node or null if one does
	 * not exist.
	 * Running Time: O(1)*/
	public Node<T> getNext() {
		return this.next;
	}
	
	/**This method will return the pointer to the previous node or null if one does not exist.
	 * Running Time: O(1)*/
	public Node<T> getPrev() {
		return this.prev;
	}
	
	/**This method will return the String representation of this node’s element.
	 * Running Time: O(1)*/
	@Override
	public String toString() {
		return "" + this.data.toString();
	}
}
