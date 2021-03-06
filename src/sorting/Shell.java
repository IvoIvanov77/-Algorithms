package sorting;


import edu.princeton.cs.algs4.StdOut;

public class Shell {
	
	
	public static <T extends Comparable<T>> void sort(T[] arr){
		
		int n = arr.length;	
		int h = 1;
		while(h < n / 3){
			h = h * 3 + 1;
		}		
		while(h >= 1){			
			for (int i = h; i < arr.length; i ++) {
				int index = i;			
				while (index >= h && less(arr[index], arr[index - h])) {				
					exch(arr, index, index - h);
					index -= h;					
				}		
				
			}
			h = h / 3;
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
		String[] arr = {"B", "D", "A", "C","W", "I", "Z", "M", "S"};
		
		Shell.sort(arr);
		Shell.show(arr);
		StdOut.println(isSorted(arr));
	}

}
