package fundamentals;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>{
	
	private Node head;
	private Node tail;
	private int size;

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListDequeIterator();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public void pushLeft(T item) {
		// TODO Auto-generated method stub
		Node node = new Node(item);
		if(head == null){
			head = node;
			tail = node;
		}else {
			node.next = head;
			head.previous = node;
			head = node;
		}
		size ++;
	}

	public T getHead() {
		if(this.head == null){
			return null;
		}
		return head.item;
	}	

	public T getTail() {
		if(this.tail == null){
			return null;
		}
		return tail.item;
	}	

	@Override
	public void pushRight(T item) {
		// TODO Auto-generated method stub
		Node node = new Node(item);
		if(head == null){
			head = node;
			tail = node;
		}else {
			tail.next = node;
			node.previous = tail;
			tail = node;
		}
		size ++;
	}

	@Override
	public T popLeft() {
		// TODO Auto-generated method stub
		T item = head.item;
		head = head.next;
		size --;
		if(isEmpty()){
			this.tail = null;
		}
		return item;
	}

	@Override
	public T popRight() {
		// TODO Auto-generated method stub
		T item = tail.item;
		tail = tail.previous;
		size --;
		if(isEmpty()){
			this.head = null;
		}
		return item;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	private class Node{		
		T item;
		Node previous;
		Node next;
		
		public Node(T item) {
			
			this.item = item;
		}		
	}
	
	private class LinkedListDequeIterator implements Iterator<T>{
		
		Node current = head;

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
