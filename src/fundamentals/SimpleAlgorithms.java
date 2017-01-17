package fundamentals;


import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class SimpleAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double xlo = Double.parseDouble(args[0]);
		double xhi = Double.parseDouble(args[1]);
		double ylo = Double.parseDouble(args[2]);
		double yhi = Double.parseDouble(args[3]);
		int T = Integer.parseInt(args[4]);
		Interval1D x = new Interval1D(xlo, xhi);
		Interval1D y = new Interval1D(ylo, yhi);
		Interval2D box = new Interval2D(x, y);
		box.draw();
		Counter c = new Counter("hits");
		for (int t = 0; t < T; t++) {
			double a = Math.random();
			double b = Math.random();
			Point2D p = new Point2D(a, b);
			if (box.contains(p))
				c.increment();
			else
				p.draw();
		}
		StdOut.println(c);
		StdOut.println(box.area());

	}

	// greatest common divisor of two nonnegative integers p and q
	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}

	// absolute value of an int value
	public static int abs(int x) {
		if (x < 0)
			return -x;
		else
			return x;
	}

	// absolute value of a double value
	public static double abs(double x) {
		if (x < 0.0)
			return -x;
		else
			return x;
	}

	// primality test
	public static boolean isPrime(int N) {
		if (N < 2)
			return false;
		for (int i = 2; i * i <= N; i++)
			if (N % i == 0)
				return false;
		return true;
	}

	// ( Newton’s method)
	public static double sqrt(double c) {
		if (c < 0) {
			return Double.NaN;
		}
		double err = 1e-15;
		double t = c;
		while (Math.abs(t - c / t) > err * t)
			t = (c / t + t) / 2.0;
		return t;
	}

	// hypotenuse of a right triangle
	public static double hypotenuse(double a, double b) {
		return Math.sqrt(a * a + b * b);
	}

	// Harmonic number
	public static double H(int N) {
		double sum = 0.0;
		for (int i = 1; i <= N; i++)
			sum += 1.0 / i;
		return sum;
	}

	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length - 1);
	}

	// Recursive implementation of binary search
	public static int rank(int key, int[] a, int lo, int hi) {
		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid])
			return rank(key, a, lo, mid - 1);
		else if (key > a[mid])
			return rank(key, a, mid + 1, hi);
		else
			return mid;
	}

	// random double value in [a, b)
	public static double uniform(double a, double b) {
		return a + StdRandom.uniform() * (b - a);
	}

	// random int value in [0..N)
	public static int uniform(int N) {
		return (int) (StdRandom.uniform() * N);
	}

	// random int value in [lo..hi)
	public static int uniform(int lo, int hi) {
		return lo + StdRandom.uniform(hi - lo);
	}

	// random int value drawn from discrete distribution (i with probability
	// a[i])
	public static int discrete(double[] a) { // Entries in a[] must sum to 1.
		double r = StdRandom.uniform();
		double sum = 0.0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
			if (sum >= r)
				return i;
		}
		return -1;
	}

	// randomly shuffle the elements in an array of double values (See Exercise
	// 1.1.36)
	public static void shuffle(double[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) { // Exchange a[i] with random element in
										// a[i..N-1]
			int r = i + StdRandom.uniform(N - i);
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	public static void drawFunctionValues(int N) {

		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N * N);
		StdDraw.setPenRadius(.01);
		for (int i = 1; i <= N; i++) {
			StdDraw.point(i, i);
			StdDraw.point(i, i * i);
			StdDraw.point(i, i * Math.log(i));
		}
	}

	public static void drawArrayOfRandomValues(int N) {
		double[] a = new double[N];
		for (int i = 0; i < N; i++) {

			a[i] = StdRandom.uniform();
		}
		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}

	public static void drawSortedArrayOfRandomValues(int N) {
		double[] a = new double[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform();
		}
		Arrays.sort(a);
		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}

	public static String toBinaryString(int number) {
		String result = "";
		for (int i = number; i > 0; i /= 2) {
			result = (i % 2) + result;
		}
		return result;
	}

	// Write a static method lg() that takes an int value N as argument and
	// returns
	// the largest int not larger than the base-2 logarithm of N. Do not use
	// Math.
	public static int lg(int n) {
		int result = 0;
		int base = 2;
		while (base <= n) {
			base *= 2;
			result++;
		}
		return result;
	}

	// Write a static method histogram() that takes an array a[] of int values
	// and
	// an integer M as arguments and returns an array of length M whose ith
	// entry is the number
	// of times the integer i appeared in the argument array. If the values in
	// a[] are all
	// between 0 and M–1, the sum of the values in the returned array should be
	// equal to
	// a.length.
	public static int[] histogram(int[] a, int m) {
		int[] result = new int[m];
		for (int i = 0; i < result.length; i++) {
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] == i) {
					count++;
				}
			}
			result[i] = count;
		}
		return result;
	}

	public static int mystery(int a, int b) {
		if (b == 0)
			return 1;
		if (b % 2 == 0)
			return mystery(a * a, b / 2);
		return mystery(a * a, b / 2) * a;
	}
}
