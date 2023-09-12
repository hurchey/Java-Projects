/**
* This class tests the DoubleLinkedList class that I created in my main package.
* Known Bugs: None that I am aware of
*
* @author Eric Hurchey
* erichurchey@brandeis.edu
* 03/12/2023
* COSI 21A PA1
*/

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;

class StudentDLLTest {

	/**Tests the toString method*/
	@Test
	public void testToString() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        assertEquals("[1, 2, 3]", list.toString());
    }
	
	/**Tests the size method*/
	@Test
	public void testSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(0, list.size());
        list.insert(1);
        assertEquals(1, list.size());
        list.insert(2);
        assertEquals(2, list.size());
    }
	
	/**Tests the get method*/
	@Test
	void testGet() {
		DoubleLinkedList<Integer> ll = new DoubleLinkedList<>();
		ll.insert(1);
		ll.insert(2);
		ll.insert(-400);
		ll.insert(-3);
		
		assertEquals(ll.get(1), 1);
		assertEquals(ll.get(2), 2);
		assertEquals(ll.get(-400), -400);
		assertEquals(ll.get(-3), -3);
		assertEquals(ll.get(1203912039), null);
	}
	
	/**Tests the delete method*/
	@Test
	public void testDelete() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.insert("Alice");
        list.insert("Bob");
        list.insert("Charlie");
        assertEquals(3, list.size());
        String deleted = list.delete("Bob");
        assertEquals("Bob", deleted);
        assertEquals(2, list.size());
        assertNull(list.get("Bob"));
    }
	
	/**Tests the insert method*/
	@Test
    public void testInsert() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.insert("Alice");
        list.insert("Bob");
        list.insert("Charlie");
        assertEquals(3, list.size());
        assertEquals("Alice", list.getFirst().data);
    }
}
