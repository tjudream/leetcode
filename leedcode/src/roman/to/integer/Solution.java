package roman.to.integer;

import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		String s = "XCIX";
		System.out.println(romanToInt(s));
	}
	public static int romanToInt(String s) {
		if (s == null || s.length() <= 0) return 0;
		HashMap<Character,Integer> romanToInt = new HashMap<Character,Integer>();
		romanToInt.put('I', 1);
		romanToInt.put('V', 5);
		romanToInt.put('X', 10);
		romanToInt.put('L', 50);
		romanToInt.put('C', 100);
		romanToInt.put('D', 500);
		romanToInt.put('M', 1000);
		
		int i = s.length() - 2;
		char c = s.charAt(s.length() - 1);
		if (romanToInt.get(c) == null) return 0;
		int res = romanToInt.get(c);
		while (i >= 0) {
			char tmp = s.charAt(i);
			if (romanToInt.get(tmp) == null) break;
			if (tmp == c || romanToInt.get(tmp) > romanToInt.get(c)) {
				res += romanToInt.get(tmp);
			} else {
				res = res - romanToInt.get(tmp);
			}
			c = tmp;
			i--;
		}
		
        return res;
    }
}
