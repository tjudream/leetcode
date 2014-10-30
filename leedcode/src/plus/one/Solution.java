package plus.one;

public class Solution {
	public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) return digits;
        int res[];
        int plus = 1;
        for (int i = len - 1;i>0;i--) {
        	if (digits[i] + plus == 10) {
        		plus = 1;
        		digits[i] = 0;
        	} else {
        		digits[i] = digits[i] + plus;
        		plus = 0;
        	}
        }
        if (digits[0] + plus < 10) {
        	digits[0] = digits[0] + plus;
        	return digits;
        } else {
        	digits[0] = 0;
        	res = new int[len + 1];
        	res[0] = 1;
        	for (int i=1;i<=len;i++) {
        		res[i] = digits[i-1];
        	}
        	return res;
        }
    }
	
	public static void main(String[] args) {
		int digits[] = {1,2,9};
		Solution s = new Solution();
		int res[] = s.plusOne(digits);
		for (int i=0;i<res.length;i++) {
			System.out.print(res[i]);
		}
	}
}
