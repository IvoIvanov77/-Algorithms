package fundamentals;

import java.util.Iterator;

import junit.framework.TestCase;

public abstract class DequeTest extends TestCase {
	
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	
	private Deque<String> deque;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.deque = createDeque();
	}

	protected abstract Deque<String> createDeque();
	
	public void testPushLeft(){
		assertTrue(deque.isEmpty());
		assertEquals(0, deque.size());
		
		deque.pushLeft(VALUE_A);
		assertFalse(deque.isEmpty());
		assertEquals(1, deque.size());		
		assertSame(VALUE_A, deque.getHead());
		assertSame(VALUE_A, deque.getTail());
		
		deque.pushLeft(VALUE_B);
		assertFalse(deque.isEmpty());
		assertEquals(2, deque.size());		
		assertSame(VALUE_B, deque.getHead());
		assertSame(VALUE_A, deque.getTail());
		
		deque.pushLeft(VALUE_C);
		assertFalse(deque.isEmpty());
		assertEquals(3, deque.size());		
		assertSame(VALUE_C, deque.getHead());
		assertSame(VALUE_A, deque.getTail());
		
		deque.pushLeft(VALUE_D);
		
		assertFalse(deque.isEmpty());
		assertEquals(4, deque.size());
		
		assertSame(VALUE_D, deque.getHead());
		assertSame(VALUE_A, deque.getTail());
	}
	
	public void testPushRight(){
		assertTrue(deque.isEmpty());
		assertEquals(0, deque.size());
		
		deque.pushRight(VALUE_A);
		assertFalse(deque.isEmpty());
		assertEquals(1, deque.size());		
		assertSame(VALUE_A, deque.getHead());
		assertSame(VALUE_A, deque.getTail());
		
		deque.pushRight(VALUE_B);
		assertFalse(deque.isEmpty());
		assertEquals(2, deque.size());		
		assertSame(VALUE_A, deque.getHead());
		assertSame(VALUE_B, deque.getTail());
		
		deque.pushRight(VALUE_C);
		assertFalse(deque.isEmpty());
		assertEquals(3, deque.size());		
		assertSame(VALUE_A, deque.getHead());
		assertSame(VALUE_C, deque.getTail());
		
		deque.pushRight(VALUE_D);
		
		assertFalse(deque.isEmpty());
		assertEquals(4, deque.size());
		
		assertSame(VALUE_A, deque.getHead());
		assertSame(VALUE_D, deque.getTail());
	}
	
	public void testPopLeft(){
		testPushRight();
		
		assertEquals(VALUE_A, deque.popLeft());
		assertFalse(deque.isEmpty());
		assertEquals(3, deque.size());		
		assertSame(VALUE_B, deque.getHead());
		assertSame(VALUE_D, deque.getTail());
		
		assertEquals(VALUE_B, deque.popLeft());
		assertFalse(deque.isEmpty());
		assertEquals(2, deque.size());		
		assertSame(VALUE_C, deque.getHead());
		assertSame(VALUE_D, deque.getTail());
		
		assertEquals(VALUE_C, deque.popLeft());
		assertFalse(deque.isEmpty());
		assertEquals(1, deque.size());		
		assertSame(VALUE_D, deque.getHead());
		assertSame(VALUE_D, deque.getTail());
		
		assertEquals(VALUE_D, deque.popLeft());
		assertTrue(deque.isEmpty());
		assertEquals(0, deque.size());		
		assertNull(deque.getHead());
		assertNull(deque.getTail());
	}
	
	public void testPopRight(){
		testPushLeft();
		
		assertEquals(VALUE_A, deque.popRight());
		assertFalse(deque.isEmpty());
		assertEquals(3, deque.size());		
		assertSame(VALUE_D, deque.getHead());
		assertSame(VALUE_B, deque.getTail());
		
		assertEquals(VALUE_B, deque.popRight());
		assertFalse(deque.isEmpty());
		assertEquals(2, deque.size());		
		assertSame(VALUE_D, deque.getHead());
		assertSame(VALUE_C, deque.getTail());
		
		assertEquals(VALUE_C, deque.popRight());
		assertFalse(deque.isEmpty());
		assertEquals(1, deque.size());		
		assertSame(VALUE_D, deque.getHead());
		assertSame(VALUE_D, deque.getTail());
		
		assertEquals(VALUE_D, deque.popRight());
		assertTrue(deque.isEmpty());
		assertEquals(0, deque.size());		
		assertNull(deque.getHead());
		assertNull(deque.getTail());
	}
	
	public void testIterator(){			
		testPushRight();
		Iterator<String> i = deque.iterator();
		String[] result = new String[deque.size()];		
		int index = 0;
		while (i.hasNext()) {
			String item = i.next();			
			result[index] = item;
			index ++;
		}
		
		assertEquals(VALUE_A, result[0]);
		assertEquals(VALUE_B, result[1]);
		assertEquals(VALUE_C, result[2]);
		assertEquals(VALUE_D, result[3]);
	}
	
	

}
