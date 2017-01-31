package sorting;

public class Merge {
	
	
	public static <T extends Comparable<T>> void sort(T[] arr){
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Comparable[arr.length];
		sort(arr, aux, 0, arr.length - 1);
		assert(isSorted(arr));
	}
	
	private static <T extends Comparable<T>> void sort(T[] arr, T[] aux,
			int lo, int hi){
		if(lo >= hi){
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid + 1, hi);
		merge(arr, aux, lo, mid, hi);
		
	}
	
	public static <T extends Comparable<T>> void merge(T[] arr, T[] aux, 
			int lo, int mid, int hi){
		int i = lo;
		int j = mid + 1;	
		
		for (int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}
		
		for(int k = lo; k <= hi; k++){
			if(i > mid){
				arr[k] = aux[j++];
			}else if(j > hi){
				arr[k] = aux[i++];
			}else if(less(aux[i], aux[j])){
				arr[k] = aux[i++];
			}else{
				arr[k] = aux[j++];
			}
		}
	}
	
	private static <T extends Comparable<T>> boolean less(T a, T b){
		return a.compareTo(b) < 0;
	}
	
	private static <T extends Comparable<T>> boolean isSorted(T[] arr){
		for (int i = 1; i < arr.length; i++) {
			if(less(arr[i], arr[i - 1])){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

	

}
