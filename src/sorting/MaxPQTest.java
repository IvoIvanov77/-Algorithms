package sorting;

import junit.framework.TestCase;

public class MaxPQTest extends TestCase{	
	
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	private static final String VALUE_E = "E";
	private static final String VALUE_F = "F";
	
	private MaxPQ<String> q = new MaxPQ<>();
	
	public void testInsert(){
		
		assertTrue(q.isEmty());
		assertEquals(0, q.size());		
		
		q.insert(VALUE_B);
		assertFalse(q.isEmty());
		assertEquals(1, q.size());		
		
		q.insert(VALUE_A);		
		q.insert(VALUE_F);
		q.insert(VALUE_D);
		q.insert(VALUE_C);
		assertFalse(q.isEmty());
		assertEquals(5, q.size());
		
		q.insert(VALUE_E);
		assertFalse(q.isEmty());
		assertEquals(6, q.size());
		
		assertEquals(VALUE_F, q.max());
	}
	
	public void testDelMax(){
		testInsert();
		
		assertFalse(q.isEmty());
		assertEquals(6, q.size());
		
		assertEquals(VALUE_F, q.delMax());
		assertEquals(VALUE_E, q.max());
		assertFalse(q.isEmty());
		assertEquals(5, q.size());
		
		assertEquals(VALUE_E, q.delMax());
		assertEquals(VALUE_D, q.max());
		assertFalse(q.isEmty());
		assertEquals(4, q.size());
		
		assertEquals(VALUE_D, q.delMax());
		assertEquals(VALUE_C, q.max());
		assertFalse(q.isEmty());
		assertEquals(3, q.size());
		
//		System.out.println(q);
		assertEquals(VALUE_C, q.delMax());
		assertEquals(VALUE_B, q.max());
		assertFalse(q.isEmty());
		assertEquals(2, q.size());
//		System.out.println(q);
		
		assertEquals(VALUE_B, q.delMax());
//		System.out.println(q);
		assertEquals(VALUE_A, q.max());
		assertFalse(q.isEmty());
		assertEquals(1, q.size());
		
		assertEquals(VALUE_A, q.delMax());		
		assertTrue(q.isEmty());
		assertEquals(0, q.size());
//		System.out.println(q);
	}
	
	

}
