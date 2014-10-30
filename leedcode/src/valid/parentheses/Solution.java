package valid.parentheses;

import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		if (s.length() == 0) return true;
		if (s.length() % 2 != 0) return false;
		int len = s.length();
		if (s.charAt(0) != '(' && s.charAt(0) != '[' && s.charAt(0) != '{') return false;
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for (int i=1;i<len;i++) {
        	Character c = null;
        	if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        		stack.push(s.charAt(i));
        	} else {
        		if (stack.isEmpty()) {
        			return false;
        		}
        		c = stack.pop();
        		if ( s.charAt(i) == ')' && c != '(') return false;
        		else if ( s.charAt(i) == ']' && c != '[') return false;
        		else if (s.charAt(i) == '}' && c != '{') return false;
        	}
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "()";
		System.out.println(s.isValid(str));
	}
}
