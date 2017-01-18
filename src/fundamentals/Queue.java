package fundamentals;

import java.util.Iterator;

import edu.princeton.cs.algs4.*;

public class Queue<T> implements Iterable<T> {

	private class Node {
		T item;
		Node next;
	}

	private Node first;
	private Node last;
	private int size;

	public boolean isEmpty() {
		return this.first == null;
	}

	public int size() {
		return this.size;
	}

	public void enqueue(T item) {
		Node oldLast = this.last;
		last = new Node();
		last.item = item;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		size++;
	}

	public T dequeue() {
		T item = first.item;
		this.first = first.next;
		if (isEmpty()) {
			this.last = null;
		}
		size--;
		return item;
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


	public static void main(String[] args) { // Create a queue and
												// enqueue/dequeue strings.
		Queue<String> q = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				q.enqueue(item);
			else if (!q.isEmpty())
				StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}

}
