package fundamentals;

import edu.princeton.cs.algs4.*;

public class AddLeftParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> ops  = new Stack<String>();
        Stack<String> vals = new Stack<String>();

        while (!StdIn.isEmpty()){
            String s = StdIn.readString();            
            if (s.equals("("));
            else if (s.equals("+") ||
                     s.equals("-") ||
                     s.equals("*") ||
                     s.equals("/") ||
                     s.equals("sqrt")) {
            	ops.push(s);
            }
            else if (s.equals(")"))
            {
                String op = ops.pop();
                String v = vals.pop();
                
                if (op.equals("+") ||
                    op.equals("-") ||
                    op.equals("*") ||
                    op.equals("/")){
                	v = String.format("( %s %s %s )", vals.pop(), op, v);                	
                }else if (op.equals("sqrt")){
                	v = String.format("( %s %s )", op, v);                	
                }                
                vals.push(v);
            }
            else vals.push(s);           
        }
        
        StdOut.println(vals.pop());

	}

}
