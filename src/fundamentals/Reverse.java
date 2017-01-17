package fundamentals;

import edu.princeton.cs.algs4.*;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		while(!StdIn.isEmpty()){
			stack.push(StdIn.readInt());
		}
		for (int integer : stack) {
			StdOut.println(integer);
		}

	}

}
