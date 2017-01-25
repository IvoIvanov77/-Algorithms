package fundamentals;

public interface Deque<T> extends Iterable<T> {
	
	boolean isEmpty();
	int size();
	void pushLeft(T item);
	void pushRight(T item); 
	T popLeft();
	T popRight();
	void clear();
	T getHead();
	T getTail();

}
