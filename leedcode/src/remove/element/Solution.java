package remove.element;

public class Solution {
	public int removeElement(int[] A, int elem) {
        int newLen = 0;
        for (int i=0;i<A.length;i++) {
        	if (A[i] != elem) {
        		A[newLen] = A[i];
        		newLen++;
        	}
        }
        return newLen;
    }
	
	public static void main(String[] args) {
		int A[] = {1,1};
		Solution s = new Solution();
		int elem = 1;
		int len = s.removeElement(A, elem);
		for (int i=0;i<len;i++) {
			System.out.print(A[i] + ",");
		}
	}
}
