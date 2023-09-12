/**
* This class provides the implementation of a generic circular first-in-first-out queue.
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package main;

import java.util.NoSuchElementException;

public class Queue<T> {

	/**Fields that I used for this class*/
	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	/**This method will construct an empty queue that can hold a specified number of elements.
	 * Running Time: O(1)*/
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		if (capacity <= 0) {
			return;
		}
		else {
			this.q = (T[]) new Object[capacity];
			this.tail = this.head = this.numEntries = 0;
		}
	}
	
	/**This method will add an element at the tail of the queue.
	 * Running Time: O(1)*/
	public void enqueue(T element) {
		this.q[this.tail] = element;
		if(this.tail == q.length - 1) {
			this.tail = 0;
		}
		else {
			this.tail++;
		}
		this.numEntries++;
	}
	
	/**This method will remove the element at the head of the queue. If there is no
	 * such element, you must throw a NoSuchElementException.
	 * Running Time: O(1)*/
	public void dequeue() { 
		if (this.q == null) {
			throw new NoSuchElementException("Queue is empty");
		}
		if (this.head == this.q.length - 1) {
			head = 0;
		}
		else {
			this.head++;
		}
		this.numEntries--;
	}
	
	/**This method will return the element at the head of the queue. If there is no such
	 * element, you must throw a NoSuchElementException.
	 * Running Time: O(1)*/
	public T front() {
		if (numEntries == 0) {
	        throw new NoSuchElementException("Queue is empty");
	    }
	    return q[head];
	}
	
	/**This method will return the number of elements in the queue.
	 * Running Time: O(1)*/
	public int size() {
		return numEntries;
	}
	
	/**This method will return the data stored in this node.
	 * Running Time: O(1)*/
	public boolean isEmpty() {
		return(this.numEntries == 0);
	}
	
	/**This method will return the data stored in this node.
	 * Running Time: O(1)*/
	public boolean isFull() {
        return ((this.head == this.tail) && this.size() > 0);
    }
	
	/**This method will return a String representation of the queue’s elements.
	 * Running Time: O(n)*/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    for (int i = 0; i < numEntries; i++) {
	        sb.append(q[(head + i) % q.length]);
	        if (i < numEntries - 1) {
	            sb.append(", ");
	        }
	    }
	    sb.append("]");
	    return sb.toString();
	}
	
	/**This method will return the data stored in this node.
	 * Running Time: O(n)*/
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (o instanceof Queue) {
			Queue<T> other = (Queue<T>) o;
			return (this.q.toString().equals(other.toString()));
		}
		return false;
	}
}
