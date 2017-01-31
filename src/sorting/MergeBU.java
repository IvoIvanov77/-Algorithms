package sorting;

public class MergeBU {
	
	
	public static <T extends Comparable<T>> void sort(T[] arr){
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Comparable[arr.length];
		
		for(int sz = 1; sz < arr.length - 1; sz *= 2){
			for(int lo = 0; lo < arr.length - sz; lo += sz * 2 ){
				merge(arr, aux, lo, lo + sz - 1, Math.min(lo + sz*2 - 1, arr.length - 1));
			}
		}
		
		assert(isSorted(arr)) : "arr is not sorted";
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
