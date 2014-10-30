package merge.sorted.array;

public class Solution {
	public void merge(int A[], int m, int B[], int n) {
        int i=m-1,j=n-1,c=m+n-1;
        while(c >=0) {
        	if (i>=0 && j>=0) {
        		if (A[i] >= B[j]) {
        			A[c] = A[i];
        			i--;
        		} else {
        			A[c] = B[j];
        			j--;
        		}
        	} else if (j>=0) {
        		A[c] = B[j];
        		j--;
        	}
        	c--;
        }
    }
	
	public static void main(String[] args) {
		int A[] = {3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};//new int[10];
		int B[] = {2,4,6,8,10};
		Solution s = new Solution();
		int m = 1;
		int n = 5;
		s.merge(A, m, B, n);
		for(int i=0;i<A.length&&A[i] != -1;i++) {
			System.out.print(A[i] + ",");
		}
	}
}
