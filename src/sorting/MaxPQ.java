package sorting;

import java.util.Arrays;

public class MaxPQ<T extends Comparable<T>> {
	
//	MaxPQ() create a priority queue
//	MaxPQ(int max) create a priority queue of initial capacity max
//	MaxPQ(Key[] a) create a priority queue from the keys in a[]
//	void insert(Key v) insert a key into the priority queue
//	Key max() return the largest key
//	Key delMax() return and remove the largest key
//	boolean isEmpty() is the priority queue empty?
//	int size() number of keys in the priority queue
	
	private int size = 0;
	private T[] arr;
	
	public MaxPQ(){
		this(1);
	}
	
	@SuppressWarnings("unchecked")
	public MaxPQ(int max){
		this.arr = (T[]) new Comparable[max + 1];
	}
	
	public MaxPQ(T[] a){
		this(a.length + 1);
		for (int i = 0; i < a.length; i++) {
			this.insert(a[i]);
		}
	}
	
	public void insert(T value){
		if(++ size >= arr.length - 1){
			resize(arr.length * 2);
		}
		arr[size] = value;
		swim(size);
	}
	
	private void swim(int index) {
		// TODO Auto-generated method stub
		int i = index;
		while(i > 1 && less(arr[i / 2], arr[i])){
			exch(i, i / 2);
			i /= 2;
		}
		
	}

	public T max(){
		return arr[1];
	}
	
	public T delMax(){
		T max = max();		
		exch(1, size --);
		arr[size + 1] = null;
		sink(1);
		if(size < arr.length / 4){
			resize(arr.length / 2);
		}
		return max;
	}
	
	private void sink(int index) {
		// TODO Auto-generated method stub		
		while(index * 2 < size){
			int j = 2 * index;
			if(less(arr[j], arr[j + 1])){
				j ++;
			}
			if(!less(arr[index], arr[j])){
				break;
			}
			exch(j, index);			
			index = j;
		}
	}

	private void exch(int i, int j) {
		// TODO Auto-generated method stub
		T value = arr[i];
		arr[i] = arr[j];
		arr[j] = value;
	}
	
	private boolean less(T a, T b){
		return a.compareTo(b) < 0;
	}

	public boolean isEmty(){
		return size() == 0;
	}
	
	public int size(){
		return this.size;
	}
	
	private void resize(int max){
		@SuppressWarnings("unchecked")
		T[] tmp = (T[])new Comparable[max];
		for (int i = 0; i < size; i++) {
			tmp[i + 1] = arr[i + 1];
		}		
		this.arr = tmp;
//		System.out.println("size: " + size);
//		System.out.println("length: " + arr.length);
	}

	@Override
	public String toString() {
		return  Arrays.toString(arr);
	}
	
	

}
