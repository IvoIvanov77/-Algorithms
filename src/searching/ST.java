package searching;

//ST() create a symbol table
//void put(Key key, Value val) put key-value pair into the table
//(remove key from table if value is null)
//Value get(Key key) value paired with key
//(null if key is absent)
//void delete(Key key) remove key (and its value) from table
//boolean contains(Key key) is there a value paired with key?
//boolean isEmpty() is the table empty?
//int size() number of key-value pairs in the table
//Iterable<Key> keys() all the keys in the table

public interface ST<K, V> {
	
	public void put(K key, V value);
	
	public V get(K key);
	
	public default void delete(K key){
		put(key, null);
	}
	
	public int size();
	
	public default boolean isEmty(){
		return size() == 0;
	}
	
	public Iterable<K> keys();
	
	boolean contains(K key);

}
