package fundamentals;

import java.util.Iterator;

public class ResizingArrayDeque<T> implements Deque<T>{
	
	private T[] array;
	private int size;
	int headIndex;
	int tailIndex;
	
	public ResizingArrayDeque() {
		// TODO Auto-generated constructor stub
		clear();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayDequeIterator();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public void pushLeft(T item) {
		// TODO Auto-generated method stub
		if(array[headIndex] == null){
			array[headIndex] = item;
			array[tailIndex] = item;
		}else{				
			if(headIndex == 0){
				resize(array.length * 2);
			}
			headIndex --;
			array[headIndex] = item;
		}
		size ++;
		
	}	

	@Override
	public void pushRight(T item) {
		// TODO Auto-generated method stub
		if(array[headIndex] == null){
			array[headIndex] = item;
			array[tailIndex] = item;
		}else{			
			if(tailIndex == array.length - 1){
				resize(array.length * 2);
			}
			tailIndex ++;
			array[tailIndex] = item;
		}
		size ++;
	}

	@Override
	public T popLeft() {
		// TODO Auto-generated method stub
		T item = array[headIndex];
		array[headIndex] = null;
		headIndex ++;
		if(size < array.length / 4){
			resize(array.length / 2);
		}
		size --;
		return item;
	}

	@Override
	public T popRight() {
		// TODO Auto-generated method stub
		T item = array[tailIndex];
		array[tailIndex] = null;
		tailIndex --;
		if(size < array.length / 4){
			resize(array.length / 2);
		}
		size --;
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.array = (T[]) new Object[3];
		this.size = 0;
		this.headIndex = 1;
		this.tailIndex = 1;
	}

	@Override
	public T getHead() {
		// TODO Auto-generated method stub
		return array[headIndex];
	}

	@Override
	public T getTail() {
		// TODO Auto-generated method stub
		return array[tailIndex];
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int lenght) {
		// TODO Auto-generated method stub
		T[] tmp = (T[]) new Object[lenght];
		int start = size / 2;	
		int end = start;
		for (int i = headIndex; i <= tailIndex; i++) {			
			tmp[end] = array[i];
			end ++;
		}
		this.array = tmp;
		this.headIndex = start;
		this.tailIndex = end - 1;
	}
	
	private class ArrayDequeIterator implements Iterator<T>{
		
		int currentIndex = headIndex;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return array[currentIndex] != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T item = array[currentIndex];
			currentIndex ++;
			return item;
		}
		
	}

}
