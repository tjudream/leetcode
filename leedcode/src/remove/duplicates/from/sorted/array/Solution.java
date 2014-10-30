package remove.duplicates.from.sorted.array;

public class Solution {
	public int removeDuplicates(int[] A) {
		int len = A.length;
		int res = 1;
		if (len <= 1) return len;
		int c = 0;
		for (int i= 1;i<len;i++) {
			if (A[i] != A[c]) {
				c++;
				A[c] = A[i];
				res++;
			}
		}
        return res;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int A[] = {1,1,2,3,3,3};
		int len = s.removeDuplicates(A);
		System.out.println("len = " + len);
		for (int i=0;i<len;i++) {
			System.out.print(A[i] + ",");
		}
	}
}
