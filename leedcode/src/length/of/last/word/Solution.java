package length.of.last.word;

public class Solution {
	public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        if (s.length() == 0) return 0;
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');
        if (lastSpaceIndex == -1) return s.length();
        return s.length() - 1 - lastSpaceIndex;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "a ";
		System.out.println(s.lengthOfLastWord(str));
	}
}
