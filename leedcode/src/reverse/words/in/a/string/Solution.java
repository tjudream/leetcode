package reverse.words.in.a.string;

public class Solution {
	public String reverse(String s) {
		char[] c = s.toCharArray();
		int l = 0;
		int r = c.length - 1;
		while(l < r) {
			char tmp = c[r];
			c[r] = c[l];
			c[l] = tmp;
			l++;
			r--;
		}
		return String.valueOf(c);
	}
	public String reverseWords(String s) {
        if (s == null) return null;
        if (s.length() < 1) return "";
        s = s.trim();
        s = reverse(s);
         
        String[] strs = s.split("( )+");
        StringBuffer sb = new StringBuffer("");
        for (int i=0;i<strs.length;i++) {
        	sb.append(reverse(strs[i]));
        	if (i!=(strs.length - 1)) sb.append(" ");
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "   a   b ";
		System.out.println(str.length());
		System.out.println("[" + s.reverseWords(str) + "]");
	}
}
