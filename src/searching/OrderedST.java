package searching;

public interface OrderedST<K extends Comparable<K> , V>  extends ST<K, V>{	
	
//	Key min() smallest key
//	Key max() largest key
//	Key floor(Key key) largest key less than or equal to key
//	Key ceiling(Key key) smallest key greater than or equal to key
//	int rank(Key key) number of keys less than key
//	Key select(int k) key of rank k
//	void deleteMin() delete smallest key
//	void deleteMax() delete largest key
//	int size(Key lo, Key hi) number of keys in [lo..hi]
//	Iterable<Key> keys(Key lo, Key hi) keys in [lo..hi], in sorted order
//	Iterable<Key> keys() all keys in the table, in sorted order
	
	K min();
	K max();
	K floor(K key);
	K ceiling(K key);
	int rank(K k);
	K select(int k);		
	Iterable<K> keys(K lo, K hi);
	
	default void deleteMin(){
		delete(min());
	}
	default void deleteMax(){
		delete(max());
	}
	default int size(K lo, K hi){
		if(hi.compareTo(lo) < 0){
			return 0;
		}else if(contains(hi)){
			return rank(hi) - rank(lo) + 1;
		}else{
			return rank(hi) - rank(lo); 
		}
		
	}
	
	@Override
	default Iterable<K> keys() {
		// TODO Auto-generated method stub
		return keys(min(), max());
	}

}
