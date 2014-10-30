//判断一个数字是否是回文数
package palindrome.number;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if (x<0 || x==Integer.MAX_VALUE) return false;
		int palindrome = 0;
		int input = x;
		while (x > 0) {
			palindrome = palindrome*10 + x%10;
			x = x/10;
		}
		return input == palindrome;
	}
	
	public static void main(String[] args) {
		int[] x={121, 10201, 102201, 102301};
		for (int i=0;i<x.length;i++) {
			System.out.println(x[i] + " " + isPalindrome(x[i]));
		}
	}
}
