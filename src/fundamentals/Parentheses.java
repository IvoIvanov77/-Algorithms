package fundamentals;

public class Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String expresion = "[()]{}{[()()]()}";
		String expresion2 = "[(])";
		System.out.println(isValid(expresion));
		System.out.println(isValid(expresion2));
		System.out.println(isValid("2 + [(34 -3)*11/(4+3)]"));
	}
	
	public static boolean isValid(String expresion){
		Stack<Character> parenthess = new Stack<>();		
		char[] tmp = expresion.toCharArray();
		
		for(char ch : tmp){
			if(isOpening(ch)){
				parenthess.push(ch);
			}else if(isClosing(ch)){
				if(parenthess.pop() != relevant(ch)){
					return false;
				}
			}			
		}
		return parenthess.isEmpty();
	}
	
	public static boolean isClosing(char ch){
		return ch == ')' || ch == '}' || ch == ']';
	}
	public static boolean isOpening(char ch){
		return ch == '(' || ch == '{' || ch == '[';
	}
	public static char relevant(char ch){
		if(ch == ')'){
			return '(';
		}
		if(ch == '}'){
			return '{';
		}
		if(ch == ']'){
			return '[';
		}
		return ' ';
	}

}
