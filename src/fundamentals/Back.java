package fundamentals;

import java.util.Iterator;



public class Back<T> implements Iterable<T>{	

	private Node first;	
	
	private class Node {
		T item;
		Node next;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}	

	public void add(T item) {
		Node oldFirst = this.first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;		
	}	

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T> {
		
		private Node current = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T item = current.item;
			current = current.next;
			return item;
		}

	}

}
