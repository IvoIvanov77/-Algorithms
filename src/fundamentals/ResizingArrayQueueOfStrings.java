package fundamentals;

import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class ResizingArrayQueueOfStrings {
	
	private String[] array;
	private int size;
	private int head;
	private int tail;

	
	public ResizingArrayQueueOfStrings() {
		this.array = new String[1];
		this.head = 0;
		this.tail = 0;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void enqueue(String item) {
		if(this.tail == this.array.length){
			resize(array.length * 2);
		}
		array[tail++] = item;
		size ++;
	}

	public String dequeue() {
		String item = array[head];
		array[head] = null;
		head ++;
		size --;
		if(size > 0 && size <= array.length / 4){
			resize(array.length / 2);			
		}
		return item;
	}
	
	private void resize(int max){		
		String[] tmp = new String[max];
		int index = 0;
		for (int i = head; i < tail; i++) {			
			tmp[index] = array[i];			
			index ++;
		}		
		this.array = tmp;
		tail = tail - head;
		this.head = 0;
		
	}
	
	
	
	@Override
	public String toString() {
		return  Arrays.toString(array);
	}

	/**
     * A test client.
     */
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")){ 
            	q.enqueue(item);            
            }
            else if (!q.isEmpty()) {
            	StdOut.print(q.dequeue() + " ");
            }
//            StdOut.println(q);
        }
        StdOut.println("(" + q.size() + " left on queue)");
}


}
