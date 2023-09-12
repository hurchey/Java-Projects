/**
* This class tests the Queue class that I created in my main package.
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import main.Queue;

class StudentQueueTest {
    
	/**This tests if the Queue is able to be Enqueue*/
	@Test
    public void testEnqueue() {
		Queue<Integer> q = new Queue<>(4);
		assertEquals(q.toString(), "[]");
		q.enqueue(1);
		assertEquals(q.toString(), "[1]");
		q.enqueue(2);
		assertEquals(q.toString(), "[1, 2]");
		q.enqueue(3);
		assertEquals(q.toString(), "[1, 2, 3]");
		q.enqueue(4);
		assertEquals(q.toString(), "[1, 2, 3, 4]");
		assertTrue(q.isFull());
    }

	/**This tests if the Queue is able to be dequeued*/
	@Test
	public void testDequeue() {
		Queue<Integer> q = new Queue<>(4);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();
		
		assertEquals(q.toString(), "[2, 3, 4]");
		q.dequeue();
		
		assertEquals(q.toString(), "[3, 4]");
		q.dequeue();
		
		assertEquals(q.toString(), "[4]");
		q.dequeue();
		
		assertEquals(q.toString(), "[]");
		assertTrue(q.isEmpty());
	}
	
	/**This tests the Queue at the front*/
    @Test
    public void testFront() {
        Queue<Integer> q = new Queue<>(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, (int) q.front());
        q.dequeue();
        assertEquals(2, (int) q.front());
        q.dequeue();
        assertEquals(3, (int) q.front());
        q.dequeue();
        try {
            q.front();
            fail("Expected a NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            assertEquals("Queue is empty", e.getMessage());
        }
    }

    /**This tests the size of the Queue*/
    @Test
    public void testSize() {
        Queue<Integer> q = new Queue<>(5);
        assertEquals(0, q.size());
        q.enqueue(1);
        assertEquals(1, q.size());
        q.enqueue(2);
        assertEquals(2, q.size());
        q.dequeue();
        assertEquals(1, q.size());
        q.enqueue(3);
        assertEquals(2, q.size());
        q.enqueue(4);
        assertEquals(3, q.size());
        q.dequeue();
        assertEquals(2, q.size());
        q.dequeue();
        assertEquals(1, q.size());
        q.dequeue();
        assertEquals(0, q.size());
    }

    /**This tests if the Queue can be written in a string*/
    @Test
    public void testToString() {
        Queue<Integer> q = new Queue<>(5);
        assertEquals("[]", q.toString());
        q.enqueue(1);
        assertEquals("[1]", q.toString());
        q.enqueue(2);
        assertEquals("[1, 2]", q.toString());
        q.enqueue(3);
        assertEquals("[1, 2, 3]", q.toString());
        q.dequeue();
        assertEquals("[2, 3]", q.toString());
        q.dequeue();
        assertEquals("[3]", q.toString());
        q.dequeue();
        assertEquals("[]", q.toString());
    }
    
    /**Tests the constructor method*/
    @Test
    void queueConstructor() {
		Queue<Integer> q = new Queue<>(4);
		assertTrue(!q.isFull());
		assertTrue(q.isEmpty());
		assertEquals(q.numEntries, 0);
		assertEquals(q.head, 0);
		assertEquals(q.tail, 0);
		assertEquals(q.size(), 0);
		
		Queue<Integer> q2 = new Queue<>(-10);
		assertTrue(!q2.isFull());
		assertTrue(q.isEmpty());
		assertEquals(q2.numEntries, 0);
		assertEquals(q2.head, 0);
		assertEquals(q2.tail, 0);
		assertEquals(q2.size(), 0);
	}
}
