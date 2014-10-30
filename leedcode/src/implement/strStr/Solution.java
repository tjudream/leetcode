package implement.strStr;

public class Solution {
	public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return null;
        if (haystack.length() == 0) {
        	if (needle.length() == 0) return haystack;
        	else return null;
        }
        int index = haystack.indexOf(needle);
        if (index < 0) return null;
        else return haystack.substring(index, haystack.length());
    }
}
