package fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
	
	public static String operators = "+-*/sqrt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Double> vals = new Stack<Double>();
		
		while (!StdIn.isEmpty()) { // Read token, push if operator.
			String s = StdIn.readString();
			if(!isOperator(s)){
				vals.push(Double.parseDouble(s));
			}else {
				double v = vals.pop();
				if (s.equals("+")){					
					v = vals.pop() + v;
				}else if (s.equals("-")){					
					v = vals.pop() - v;
				}else if (s.equals("*")){					
					v = vals.pop() * v;
				}else if (s.equals("/")){					
					v = vals.pop() / v;
				}else if (s.equals("sqrt")){					
					v = Math.sqrt(v);
				}
				vals.push(v);
			}
			
		}
		StdOut.println(vals.pop());
	}
	
	public static boolean isOperator(String str){
		return operators.contains(str);
	}

}
