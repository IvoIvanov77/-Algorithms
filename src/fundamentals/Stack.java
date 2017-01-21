package fundamentals;

import java.util.Iterator;


public class Stack<T> implements Iterable<T>{
	
	private class Node {
		T item;
		Node next;
	}

	private Node first;
	private int size;
	
	public boolean isEmpty() {
		return this.first == null;
	}

	public int size() {
		return this.size;
	}

	public void push(T item) {
		Node oldFirst = this.first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size ++;
	}

	public T pop() {
		T item = first.item;
		this.first = first.next;
		size --;
		return item;
	}
	
	public T peek(){
		return first.item;
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
