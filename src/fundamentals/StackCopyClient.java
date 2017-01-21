package fundamentals;

import java.util.Iterator;

public class StackCopyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < 10; i ++){
			String s = "" + i;
			stack.push(s);
		}
		Stack<String> copy = copy(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		while(!copy.isEmpty()){
			System.out.println(copy.pop());
		}

	}
	
	public static Stack<String> copy(Stack<String> stack){		
		Stack<String> tmp = new Stack<>();
		Iterator<String> i = stack.iterator();
		while(i.hasNext()){
			tmp.push(i.next());
		}
		Stack<String> result = new Stack<>();
		Iterator<String> it = tmp.iterator();
		while(it.hasNext()){
			result.push(it.next());
		}
		return result;
	}
	
	

}
