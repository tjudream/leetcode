package evaluate.reverse.polish.notation;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
	public boolean isOperator(String str) {
		switch (str) {
		case "+":
		case "-":
		case "*":
		case "/": return true;
		default: return false;
		}
	}
	public int calcul(int a, int b, String op) {
		switch (op) {
		case "+": return (a+b);
		case "-": return (a-b);
		case "*": return (a*b);
		case "/": if (b != 0) return (a/b);
		default: return 0;
		}
	}
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0;i<tokens.length;i++) {
        	if (isOperator(tokens[i])) {
        		int a = stack.pop();
        		int b = stack.pop();
        		stack.push(calcul(b,a,tokens[i]));
        	} else {
        		stack.push(Integer.parseInt(tokens[i]));
        	}
        }
        return stack.pop();
    }
}
