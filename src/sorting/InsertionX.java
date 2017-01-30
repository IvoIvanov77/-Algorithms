package sorting;


import edu.princeton.cs.algs4.StdOut;

public class InsertionX {
	
	public static <T extends Comparable<T>> void sort(T[] arr){
		
		int exchanges = 0;
		for(int i = arr.length - 1; i > 0; i --){
			if(less(arr[i], arr[i - 1])){
				exch(arr, i, i - 1);
				exchanges ++;
			}
		}
		if(exchanges == 0){
			return;
		}
		
		for (int i = 1; i < arr.length; i++) {
			int index = i;
			T item = arr[index];
			while (index > 0 && less(item, arr[index - 1])) {				
				arr[index] = arr[index - 1];
				index --;	
				
			}
			arr[index] = item;			
		}
		assert(isSorted(arr));
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
		
		InsertionX.sort(arr);
		InsertionX.show(arr);
		StdOut.println(isSorted(arr));
	}

}
