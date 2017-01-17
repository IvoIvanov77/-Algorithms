package fundamentals;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.ClosestPair;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

public class Point2DClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point2D[] randomPoints = randomPoints(10);
		System.out.println(Arrays.toString(randomPoints));
		ClosestPair pair = new ClosestPair(randomPoints);
		StdOut.println(pair.distance());
		StdOut.println(pair.either() + " " + pair.other());
		
	}
	
	public static Point2D[] randomPoints(int n){
		Random r = new Random();
		Point2D[] result = new Point2D[n];
		for (int i = 0; i < result.length; i++) {
			double x = r.nextDouble();
			double y = r.nextDouble();
			result[i] = new Point2D(x, y);
		}
		return result;
	}
	
	

}
