package fundamentals;



import java.util.Iterator;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {
	
	protected static final String VALUE_A = "A";
	protected static final String VALUE_B = "B";
	protected static final String VALUE_C = "C";
	private LinkedList<String> list;
	
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.list = new LinkedList<>();
	}

	public void testApend(){
		
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		list.append(VALUE_A);
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertSame(list.get(0), VALUE_A);
		assertSame(list.getHead(), VALUE_A);
		assertSame(list.getTail(), VALUE_A);
		
		list.append(VALUE_B);
		assertEquals(2, list.size());
		assertFalse(list.isEmpty());
		assertSame(list.get(0), VALUE_A);
		assertSame(list.get(1), VALUE_B);
		assertSame(list.getHead(), VALUE_A);
		assertSame(list.getTail(), VALUE_B);
		
		list.append(VALUE_C);
		assertEquals(3, list.size());
		assertFalse(list.isEmpty());
		assertSame(list.get(0), VALUE_A);
		assertSame(list.get(1), VALUE_B);
		assertSame(list.get(2), VALUE_C);
		assertSame(list.getHead(), VALUE_A);
		assertSame(list.getTail(), VALUE_C);
		
	}
	
	public void testPrepend(){	
		
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		list.prepend(VALUE_A);
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertSame(list.get(0), VALUE_A);
		assertSame(list.getHead(), VALUE_A);
		assertSame(list.getTail(), VALUE_A);
		
		list.prepend(VALUE_B);
		assertEquals(2, list.size());
		assertFalse(list.isEmpty());
		assertSame(list.get(0), VALUE_B);
		assertSame(list.get(1), VALUE_A);
		assertSame(list.getHead(), VALUE_B);
		assertSame(list.getTail(), VALUE_A);
		
		list.prepend(VALUE_C);
		assertEquals(3, list.size());
		assertFalse(list.isEmpty());
		assertSame(list.get(0), VALUE_C);
		assertSame(list.get(1), VALUE_B);
		assertSame(list.get(2), VALUE_A);
		assertSame(list.getHead(), VALUE_C);
		assertSame(list.getTail(), VALUE_A);		
	}
	
	public void testRemoveFirst(){
		testApend();
		assertEquals(3, list.size());
		assertFalse(list.isEmpty());
		
		assertEquals(VALUE_A, list.removeFirst());
		assertEquals(2, list.size());
		assertSame(list.getHead(), VALUE_B);
		
		assertEquals(VALUE_B, list.removeFirst());
		assertEquals(1, list.size());
		assertSame(list.getHead(), VALUE_C);
		
		assertEquals(VALUE_C, list.removeFirst());
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}
	
	public void testIterator(){
		testApend();
		Iterator<String> i = list.iterator();
		String result = "";
		while(i.hasNext()){
			result += i.next();
		}
		assertEquals("ABC", result);
	}
	
	public void testRemoveLast(){
		testApend();		
		
		assertEquals(VALUE_C, list.removeLast());
		assertEquals(2, list.size());
		assertSame(VALUE_B, list.getTail());
		
		assertEquals(VALUE_B, list.removeLast());
		assertEquals(1, list.size());
		assertSame(VALUE_A, list.getTail());
		
		assertEquals(VALUE_A, list.removeLast());
		assertEquals(0, list.size());
	}
	
	public void testDeleteByIndex(){
		testApend();
		assertEquals(VALUE_B, list.delete(1));
		assertEquals(2, list.size());
		assertEquals(VALUE_A, list.delete(0));
		assertEquals(1, list.size());
	}
	
	public void testDeleteByValue(){
		testApend();
		assertTrue(list.delete("C"));
		assertEquals(2, list.size());
		assertSame(VALUE_B, list.getTail());
		
		assertTrue(list.delete("A"));
		assertEquals(1, list.size());
		assertSame(VALUE_B, list.getTail());
		assertSame(VALUE_B, list.getHead());
		
		assertFalse(list.delete("D"));
		assertEquals(1, list.size());
		
		assertTrue(list.delete("B"));
		assertEquals(0, list.size());
	}
	
	public void testContains(){
		testApend();
		assertTrue(list.contains("A"));
		assertTrue(list.contains("B"));
		assertTrue(list.contains("C"));
		assertFalse(list.contains("D"));
	}
	
	public void testDeleteAll(){
		testApend();
		for(int i = 0; i < 10; i ++){
			list.append(VALUE_A);
		}
		assertTrue(list.contains(VALUE_A));
		assertEquals(13, list.size());
		list.deleteAll(VALUE_A);
		
		assertFalse(list.contains(VALUE_A));
		assertEquals(2, list.size());
		assertSame(VALUE_C, list.getTail());
		assertSame(VALUE_B, list.getHead());
	}
	
	public void testGet(){
		testPrepend();
		assertEquals(VALUE_A, list.get(2));
		assertEquals(VALUE_C, list.get(0));
		assertEquals(VALUE_B, list.get(1));
	}
	
	public void testReverse(){
		testApend();
		assertEquals(VALUE_A, list.get(0));
		assertEquals(VALUE_C, list.get(2));
		assertEquals(VALUE_B, list.get(1));
		list.reverse();
		assertEquals(VALUE_A, list.get(2));
		assertEquals(VALUE_C, list.get(0));
		assertEquals(VALUE_B, list.get(1));
	}

}
