package fundamentals;

public class FixedCapacityStack<T> {
	
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int size) {
		this.array = (T[])new Object[size];
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void push(T item) {
		if(this.size == this.array.length){
			resize(array.length * 2);
		}
		array[size++] = item;
	}

	public T pop() {
		T item = array[--size];
		array[size] = null;
		if(size > 0 && size <= array.length / 4){
			resize(array.length / 2);
		}
		return item;
	}
	
	private void resize(int max){
		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Object[max];
		for (int i = 0; i < array.length; i++) {
			tmp[i] = array[i];
		}
		this.array = tmp;
	}


}
