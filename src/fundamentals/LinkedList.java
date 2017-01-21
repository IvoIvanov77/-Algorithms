package fundamentals;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
	
	private Node head;
	private Node tail;
	private int size;
	
	private class Node {
		T item;
		Node next;
		public Node(T item, Node next) {
			super();
			this.item = item;
			this.next = next;
		}
		
		
	}
	
	public LinkedList() {
		// TODO Auto-generated constructor stub
		clear();
	}
	
	public void clear(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return this.head == null;
	}	

	public T getHead() {
		return head.item;
	}

	public T getTail() {
		return tail.item;
	}

	public int size() {
		return size;
	}
	
	public T removeFirst(){
		T item = head.item;
		head = head.next;
		size --;
		return item;
	}
	
	public void prepend(T item){
		Node node = new Node(item, head);
		if(isEmpty()){
			this.tail = node;
		}
		this.head = node;		
		size ++;
		
	}
	
	public void append(T item){
		Node node = new Node(item, null);
		if(isEmpty()){
			this.head = node;
			this.tail = node;
		}
		tail.next = node;
		tail = node;
		size ++;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T>{
		
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
	
	/*****************
     * Exercise 1.3.19
     *****************/
	public T removeLast(){
		assert !isEmpty(): "List is emty";		
		return delete(size - 1);	
	}
	
	/*****************
     * Exercise 1.3.20
     *****************/
	public T delete(int index){
		if(index >= this.size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		if(index == 0){
			return removeFirst();
		}		
		int n = 0;
		Node node = this.head;
		while(n < index - 1){
			node = node.next;
			n ++;
		}
		if(n == this.size - 2){
			this.tail = node;
		}
		T item = node.next.item;
		node.next = node.next.next;
		size --;
		return item;
	}
	
	/*************************************
     * Exercise 1.3.21     
     *************************************/
	public boolean contains(T item){
		Iterator<T> i = this.iterator();
		while(i.hasNext()){
			if(i.next() == item){
				return true;
			}
		}
		return false;
	}
	
	/*****************
     * Exercise 1.3.24
     *****************/
	private void removeAfter(Node node){
		if(node != null && node.next != null){
			node.next = node.next.next;
		}
	}
	
	private void insertAfter(Node one, Node two){
		if(one != null && two != null){
			two.next = one.next;
			one.next = two;
		}
	}
	
	public void deleteAll(T item){
		while(delete(item)){
			
		}
	}
	
	public boolean delete(T item){
		Node current = this.head;
		int index = 0;
		while(current != null){
			if(current.item == item){
				delete(index);
				return true;
			}
			current = current.next;
			index ++;
		}
		return false;
	}
	
	public T get(int index){
		Node node = this.head;
		int n = 0;
		while(n < index){
			node = node.next;
			n ++;
		}
		return node.item;
	}

}
