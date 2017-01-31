package sorting;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	
	
	public static <T extends Comparable<T>> void sort(T[] arr){		
		StdRandom.shuffle(arr);
		sort(arr, 0, arr.length - 1);
		assert(isSorted(arr));
	}
	
	private static <T extends Comparable<T>> void sort(T[]arr, int lo, int hi){
		if(hi <= lo){				
			return;
		}
		int j = partition(arr, lo, hi);
		sort(arr, lo, j);
		sort(arr, j + 1, hi);
	}
	
	private static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi){
		int i = lo;
		int j = hi + 1;
		T v = arr[lo];
		
		while(true){
			while(less(arr[--j], v)){
				if(j == lo){
					break;
				}
			}
			while(less(v, arr[++i])){
				if(i == hi){
					break;
				}
			}
			if(i >= j){
				break;
			}
			exch(arr, i, j);
		}
		exch(arr, lo, j);
		return j;
	}
	
	private static <T extends Comparable<T>> boolean less(T a, T b){
		return a.compareTo(b) < 0;
	}
	
	private static <T extends Comparable<T>> void exch(T[] arr, int i, int j){
		T item = arr[i];
		arr[i] = arr[j];
		arr[j] = item;
	}
	
	public static <T> void show(T[] arr){
		for (int i = 0; i < arr.length; i++) {
			StdOut.print(arr[i] + " ");
		}
		StdOut.println();
	}
	
	public static <T extends Comparable<T>> boolean isSorted(T[] arr){
		for (int i = 1; i < arr.length; i++) {
			if(less(arr[i], arr[i - 1])){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		String[] arr = {"B", "D", "A", "C","W", "I", "Z", "M", "S"};
		
		Quick.sort(arr);
		Quick.show(arr);
		StdOut.println(isSorted(arr));
	}

}
