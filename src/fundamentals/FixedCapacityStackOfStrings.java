package fundamentals;

import edu.princeton.cs.algs4.*;

public class FixedCapacityStackOfStrings {

	private String[] array;
	private int size;

	public FixedCapacityStackOfStrings(int size) {
		this.array = new String[size];
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void push(String item) {
		array[size++] = item;
	}

	public String pop() {
		return array[--size];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedCapacityStackOfStrings s;
		s = new FixedCapacityStackOfStrings(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");

	}

}
