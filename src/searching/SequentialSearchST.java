package searching;

public class SequentialSearchST<K, V> implements ST<K, V>{
	
	private Node head;
	private int size;
	
	private class Node {
		
		K key;
		V value;
		Node next;
		
		public Node(K key, V value, Node next) {
			
			this.key = key;
			this.value = value;
			this.next = next;
		}	

	}


	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		Node node = getNode(key);
		if(node != null){
			node.value = value;
		}else {
			this.head = new Node(key, value, head);
			size ++;
		}
		
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		Node node = getNode(key);
		if(node != null){
			return node.value;
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub		
		return getNode(key) != null;
	}
	
	private Node getNode(K key){
		for(Node node = head; node != null; node = node.next){
			if(key.equals(node.key)){
				return node;
			}
		}
		return null;
	}
	
//	private void add(Node node){
//		if(head == null){
//			head = node;
//		}else {
//			node.next = head;
//			head = node;
//		}
//	}

}
