/**
* This class provides the implementation of a generic non-circular doubly linked list. 
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package main;

public class DoubleLinkedList<T> {

	/**Fields that I used for this class*/
	public Node<T> head;
	public Node<T> tail;
	public int size;
	public T data;
	
	/**This method will construct a double linked list
	 * Running Time: O(1)*/
	public DoubleLinkedList() {
		head = new Node<T>(null);
		size = 0;
	}
	
	/**This method will get the first node in the list or null if one does not exist.
	 * Running Time: O(n)*/
	public Node<T> getFirst() {
		if (this.size() == 0) {
			return null;
		}
		return head;
	}
	
	/**This method will adds an element to the end of this list
	 * Running Time: O(n)*/
	public void insert(T element) {		
		Node<T> newNode = new Node<T>(element);
        if (this.head.data == null) {
            this.head = newNode;
        } 
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        this.size++;
	}
	
	/**This method will deletes the first element from this list that matches the provided key. 
	 * If the provided key does not exist in the list, return null.
	 * Running Time: O(n)*/
	public T delete(T key) {
	    Node<T> current = this.head;
        while (!current.data.equals(key)) {
            if (current.next == null) return null;
            current = current.next;
        }

        if (current.prev == null) {
            if (this.size() == 1) {
                this.head.data = null;
            }
            else {
                current.next.prev = null;
                this.head = current.next;
            }
        }
        else if (current.next == null) current.prev.next = null;
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        this.size--;
		return current.data;
	}
	
	/**This method will return the first element in the list that matches the provided 
	 * key or null if one cannot be found.
	 * Running Time: O(n)*/
	public T get(T key) {
		Node<T> current = head;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        return current.data;
	}
	
	/**This method will return the number of elements in the list.
	 * Running Time: O(1)*/
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
        return (size == 0);
    }
	
	/**This method will return a String representation of this list’s elements.
	 * Running Time: O(n)*/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
	}
}
