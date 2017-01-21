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
	
//	public void testInsertBetweenElements(){
//		List<String> list = createList();
//		
//		list.insert(0, VALUE_A);
//		list.insert(1, VALUE_B);
//		list.insert(1, VALUE_C);
//		
//		assertEquals(3, list.size());
//		
//		assertSame(list.get(0), VALUE_A);
//		assertSame(list.get(1), VALUE_C);
//		assertSame(list.get(2), VALUE_B);
//		
//	}
//	
//	public void testInsertBeforeFirstElement(){
//		List<String> list = createList();
//		
//		list.insert(0, VALUE_A);
//		list.insert(0, VALUE_B);		
//		
//		assertEquals(2, list.size());
//		
//		assertSame(list.get(0), VALUE_B);
//		assertSame(list.get(1), VALUE_A);		
//	}
//	
//	public void testInsertAfterLastElement(){
//		List<String> list = createList();
//		
//		list.insert(0, VALUE_A);
//		list.insert(1, VALUE_B);		
//		
//		assertEquals(2, list.size());
//		
//		assertSame(VALUE_A, list.get(0));
//		assertSame(VALUE_B, list.get(1));	
//	}
//	
//	public void testInsertOutOfBounds(){
//		List<String> list = createList();
//		
//		try {
//			list.insert(-1, VALUE_A);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			
//		}
//		
//		try {
//			list.insert(1, VALUE_B);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			
//		}
//	}
//	
//	public void testAdd(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_C);
//		list.add(VALUE_B);
//		
//		assertEquals(3, list.size());
//		
//		assertSame(VALUE_A, list.get(0));
//		assertSame(VALUE_C, list.get(1));
//		assertSame(VALUE_B, list.get(2));
//	}
//	
//	public void testSet(){		
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		assertSame(VALUE_A, list.get(0));
//		
//		assertSame(VALUE_A, list.set(0, VALUE_B));		
//		assertSame(VALUE_B, list.get(0));
//		
//	}
//	
//	public void testGetOutOfBounds(){
//		List<String> list = createList();
//		
//		try {
//			list.get(-1);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			
//		}
//		
//		try {
//			list.get(0);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			
//		}
//		
//		list.add(VALUE_A);
//		
//		try {
//			list.get(1);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			
//		}
//	}
//	
//	public void testSetOutOfBounds(){
//		List<String> list = createList();
//		
//		try {
//			list.set(-1, VALUE_A);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			
//		}
//		
//		try {
//			list.set(0, VALUE_B);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			
//		}
//		
//		list.insert(0, VALUE_C);;
//		
//		try {
//			list.set(1, VALUE_C);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			
//		}
//	}
//	
//	public void testDeleteOnlyElement(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);		
//		assertEquals(1, list.size());
//		assertSame(VALUE_A, list.get(0));
//		assertSame(VALUE_A, list.delete(0));
//		assertEquals(0, list.size());
//		assertTrue(list.isEmpty());
//		
//	}
//	
//	public void testDeleteFirstElement(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_B);
//		list.add(VALUE_C);
//		
//		assertEquals(3, list.size());
//		assertSame(VALUE_A, list.get(0));
//		assertSame(VALUE_B, list.get(1));
//		assertSame(VALUE_C, list.get(2));
//		
//		assertSame(VALUE_A, list.delete(0));
//		assertSame(VALUE_B, list.get(0));
//		assertSame(VALUE_C, list.get(1));
//	}
//	
//	public void testDeleteLastElement(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_B);
//		list.add(VALUE_C);
//		
//		assertEquals(3, list.size());
//		assertSame(VALUE_A, list.get(0));
//		assertSame(VALUE_B, list.get(1));
//		assertSame(VALUE_C, list.get(2));
//		
//		assertSame(VALUE_C, list.delete(2));
//		assertSame(VALUE_A, list.get(0));
//		assertSame(VALUE_B, list.get(1));
//	}
//	
//	public void testDeleteMiddleElement(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_B);
//		list.add(VALUE_C);
//		
//		assertEquals(3, list.size());
//		assertSame(VALUE_A, list.get(0));
//		assertSame(VALUE_B, list.get(1));
//		assertSame(VALUE_C, list.get(2));
//		
//		assertSame(VALUE_B, list.delete(1));
//		assertSame(VALUE_A, list.get(0));
//		assertSame(VALUE_C, list.get(1));
//	}
//	
//	public void testDeleteOutOfBounds(){
//		List<String> list = createList();
//		
//		try {
//			list.delete(-1);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block			
//		}
//		
//		try {
//			list.delete(0);
//			fail();
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block			
//		}
//	}
//	
//	public void testDeleteByValue(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_B);
//		list.add(VALUE_A);
//		
//		assertEquals(3, list.size());
//		assertSame(VALUE_A, list.get(0));
//		assertSame(VALUE_B, list.get(1));
//		assertSame(VALUE_A, list.get(2));
//		
//		assertTrue(list.delete(VALUE_A));
//		assertEquals(2, list.size());		
//		assertSame(VALUE_B, list.get(0));
//		assertSame(VALUE_A, list.get(1));
//		
//		assertTrue(list.delete(VALUE_A));
//		assertEquals(1, list.size());		
//		assertSame(VALUE_B, list.get(0));
//		
//		assertFalse(list.delete(VALUE_C));
//		
//		assertEquals(1, list.size());		
//		assertSame(VALUE_B, list.get(0));
//		
//		assertTrue(list.delete(VALUE_B));
//		assertEquals(0, list.size());			
//	}
//	
//	public void testEmptyIteration(){
//		List<String> list = createList();
//		
//		Iterator<String> iterator = list.iterator();
//		
//		assertTrue(iterator.isDone());
//		
//		try {
//			iterator.current();
//			fail();
//		} catch (IteratorOutOfBoundsException e) {
//			// TODO Auto-generated catch block			
//		}
//	}
//	
//	public void testForwardIteration(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_B);
//		list.add(VALUE_C);
//		
//		Iterator<String> iterator = list.iterator();
//		
//		iterator.first();
//		assertFalse(iterator.isDone());
//		assertSame(VALUE_A, iterator.current());
//		
//		iterator.next();
//		assertFalse(iterator.isDone());
//		assertSame(VALUE_B, iterator.current());
//		
//		iterator.next();
//		assertFalse(iterator.isDone());
//		assertSame(VALUE_C, iterator.current());
//		
//		iterator.next();
//		assertTrue(iterator.isDone());
//		try {
//			iterator.current();
//			fail();
//		} catch (IteratorOutOfBoundsException e) {
//			// TODO Auto-generated catch block			
//		}
//	}
//	
//	public void testReverseIteration(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_B);
//		list.add(VALUE_C);
//		
//		Iterator<String> iterator = list.iterator();
//		
//		iterator.last();
//		assertFalse(iterator.isDone());
//		assertSame(VALUE_C, iterator.current());
//		
//		iterator.previous();
//		assertFalse(iterator.isDone());
//		assertSame(VALUE_B, iterator.current());
//		
//		iterator.previous();
//		assertFalse(iterator.isDone());
//		assertSame(VALUE_A, iterator.current());
//		
//		iterator.previous();
//		assertTrue(iterator.isDone());
//		try {
//			iterator.current();
//			fail();
//		} catch (IteratorOutOfBoundsException e) {
//			// TODO Auto-generated catch block			
//		}
//	}
//	
//	public void testIndexOf(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_B);
//		list.add(VALUE_A);
//		
//		assertSame(0, list.indexOf(VALUE_A));
//		assertSame(1, list.indexOf(VALUE_B));
//		assertSame(-1, list.indexOf(VALUE_C));
//	}
//	
//	public void testContains(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_B);
//		list.add(VALUE_A);
//		
//		assertTrue(list.contains(VALUE_A));
//		assertTrue(list.contains(VALUE_B));
//		assertFalse(list.contains(VALUE_C));
//	}
//	
//	public void testClear(){
//		List<String> list = createList();
//		
//		list.add(VALUE_A);
//		list.add(VALUE_B);
//		list.add(VALUE_B);
//		
//		assertEquals(3, list.size());
//		assertFalse(list.isEmpty());
//		
//		list.clear();
//		assertEquals(0, list.size());
//		assertTrue(list.isEmpty());
//	}

}
