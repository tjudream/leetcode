package count.and.say;

public class Solution {
	public static void main(String[] args) {
		countAndSay(5);
	}
	public static String countAndSay(int n) {
		if (n<1) return null;
        int input = n;
        
        String str = "1";

        while(input > 1) {
        	input--;
        	StringBuffer sb = new StringBuffer();
        	int i = 1;
        	char c = str.charAt(0);
        	int len = str.length();
        	int count = 1;
        	while (i<len) {
        		if (c == str.charAt(i)) {
        			count++;
        			i++;
        		} else {
        			sb.append(count);
        			sb.append(c);
        			//= tmp + count + c;
        			c = str.charAt(i);
        			i++;
        			count = 1;
        		}
        	}
        	str = sb.toString() + count + c;
        	//System.out.println(str);
        }
        
        //System.out.println(str);
        return str;
    }
}
