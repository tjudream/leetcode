package longest.common.prefix;

public class Solution {
	public static void main(String[] args) {
		String[] strs = {
			"a",
			"b",
			"abc12345"
		};
		System.out.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n<1)
            return "";
        int len0 = strs[0].length();
        int i, j;
        outer: for (i = 0; i < len0; i++) {
            char cur = strs[0].charAt(i);
            for (j = 1; j < n; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != cur) {
                    break outer;
                }
 
            }
        }
        System.out.println(i);
        return strs[0].substring(0, i);
    }
}
