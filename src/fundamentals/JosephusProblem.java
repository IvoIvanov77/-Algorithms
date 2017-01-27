package fundamentals;

import edu.princeton.cs.algs4.StdOut;

public class JosephusProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int people = Integer.parseInt(args[0]);
		int eliminated = Integer.parseInt(args[1]);
		
		Queue<Integer> q = new Queue<>();
		
		for(int i = 0; i < people; i ++){
			q.enqueue(i);
		}
		int index = 0;
		while(!q.isEmpty()){
			int x = q.dequeue();
			if(++ index  % eliminated == 0){
				StdOut.print(x + " ");
			}else{
				q.enqueue(x);
			}
		}

	}

}
