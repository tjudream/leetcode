package valid.palindrome;

public class Solution {
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		//s = "race a car";//false
		//s = ".,";
		//s = "1a1";
		System.out.println( isPalindrome(s) );
	}
	public static boolean isPalindrome(String s) {
		if (s == null) return true;
		s = s.trim();
		s = s.toLowerCase();
		int b = 0, e = s.length() -1;
		boolean flg = true;
		while (b < e) {
			while ( b < s.length() && !((s.charAt(b) >= 'a' && s.charAt(b) <= 'z') || (s.charAt(b) >= '0' && s.charAt(b) <='9')) ) b++;
			if (b >= s.length()) break;
			char bc = s.charAt(b);
			while ( e > 0 && !((s.charAt(e) >= 'a' && s.charAt(e) <= 'z') || (s.charAt(e) >= '0' && s.charAt(e) <='9')) ) e--;
			if (e <= 0) break;
			char ec = s.charAt(e);
			if (bc != ec) {
				flg = false;
				break;
			}
			b++;
			e--;
		}
		return flg;
    }
}
