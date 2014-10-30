package climbing.stairs;

public class Solution {
	
	public int f[];
	public int stepsNum(int n) {
		if (n == 0 || n == 1) return 1;
		if (f[n] != -1) return f[n];
		f[n] = stepsNum(n-1) + stepsNum(n-2);
		return f[n];
	}
	public int climbStairs(int n) {
		f = new int[n+1];
		for (int i=0;i<=n;i++) {
			f[i] = -1;
		}
        return stepsNum(n);
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 80;
		System.out.println(s.climbStairs(n));
	}
}
