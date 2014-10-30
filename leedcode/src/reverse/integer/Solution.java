package reverse.integer;

public class Solution {
	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}
	public static int reverse(int x) {
		int res = 0;
		int flg = 1;
		if (x < 0) {
			flg = -1;
			x = flg*x;
		}
		while(x>0) {
			res = res*10 + x%10;
			x/=10;
		}
		res = flg*res;
        return res;
    }
}
