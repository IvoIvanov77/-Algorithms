package sorting;

import edu.princeton.cs.algs4.StdOut;

public class Selection {
	
	public static <T extends Comparable<T>> void sort(T[] arr){
		
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if(less(arr[j], arr[min])){
					min = j;
				}
			}			
			exch(arr, i, min);
		}
		
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
		String[] arr = {"B", "D", "A", "C"};
		
		Selection.sort(arr);
		Selection.show(arr);
		StdOut.println(isSorted(arr));
	}

}
