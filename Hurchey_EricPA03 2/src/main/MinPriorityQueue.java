/**
 * This class is a data structure that allows you to add items with certain priorities, 
 * and then be able to extract the item with the lowest priority in O(1) time.
 * Known Bugs: None that I know of
 * 
 * @author Eric Hurchey
 * erichurchey@brandeis.edu
 * Due May 09, 2023
 * COSI 21A PA03
 */

package main;

import java.util.NoSuchElementException;

public class MinPriorityQueue {

	//This is the list of Fields that I used in this class
	
    private GraphNode[] heap;
    private int size;
    private HashMap map;
    private int capacity;

    //These are the following operations that are required in this class.
    
    public MinPriorityQueue() {
    	this.capacity = 30;
    	this.heap = new GraphNode[capacity];
    	this.size = 0;
    	this.map = new HashMap();
    }

    public void insert(GraphNode g) {
        if (size == heap.length) {
            resize();
        }
        heap[size] = g;
        heapifyUp(size);
        size++;
        map.set(g, size);
    }

    public GraphNode pullHighestPriorityElement() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        GraphNode min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }
    
    public void rebalance(GraphNode g) {
        heapify(g);
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void heapify(GraphNode g) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (heap[i] == g) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Node not found in priority queue.");
        }
        heapifyUp(index);
        heapifyDown(index);
    }

    
    
    //These following methods are helper methods for the operations above.    
    
    /**
     * This method will resize the hash table if needed
     */
    private void resize() {
        GraphNode[] newHeap = new GraphNode[2 * heap.length];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    /**
     * This method will heapify up the hash map if needed
     * @param index <- the index that will be heapify up 
     */
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index].priority < heap[parentIndex].priority) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    /**
     * This method will heapify down the hash map if needed
     * @param index <- the index that will be heapify down
     */
    private void heapifyDown(int index) {
        int childIndex = 2 * index + 1;
        while (childIndex < size) {
            if (childIndex + 1 < size && heap[childIndex + 1].priority < heap[childIndex].priority) {
                childIndex++;
            }
            if (heap[index].priority <= heap[childIndex].priority) {
                break;
            }
            swap(index, childIndex);
            index = childIndex;
            childIndex = 2 * index + 1;
        }
    }

    /**
     * This method will swap the index that is being heapified to the one that is in the way of
     * that index
     * @param i <- the index that is heapified
     * @param j <- the index that is going to swap with the heapified index
     */
    private void swap(int i, int j) {
        GraphNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * This method will check that the node has a value
     * @param node <- the node that is being looked at
     * @return true or false if there exists a node
     */
    public boolean contains(GraphNode node) {
        return map.hasKey(node);
    }
    
    /**
     * This method will decrease the priority queue 
     * @param node
     */
    public void decreasePriorityQueue(GraphNode node) {
      int index = -1;
      for (int i = 1; i <= size; i++) {
          if (heap[i] == node) {
              index = i;
              break; //This break is important so that there is no Array Index Out of Bounds Exception
          }
      }
      if (index == -1) {
          throw new IllegalArgumentException("Node not found in queue");
      }
      heap[index].priority = node.priority;
      while (index > 1 && heap[index].priority < heap[index/2].priority) {
          swap(index, index/2);
          index /= 2;
      }
    }
}

