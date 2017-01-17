package fundamentals;

import edu.princeton.cs.algs4.*;

public class Stats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag<Double> bag = new Bag<>();
		
		while(!StdIn.isEmpty()){
			double n = StdIn.readDouble();
			bag.add(n);
		}		
		double sum = 0;
		for(double number : bag){
			sum += number;
		}
		double avg = sum / bag.size();
		
		sum = 0;
		for(double number : bag){
			sum += (number - avg) * (number - avg);
		}
		double std = Math.sqrt(sum / (bag.size() - 1));
		
		StdOut.printf("Mean: %.2f\n", avg);
		StdOut.printf("Std dev: %.2f\n", std);

	}

}
