package find.minimum.in.rotated.sorted.array;
//二分查找
public class Solution {
	/*
	public int findMin(int[] num) {
        if (num.length == 0) return 0;
        int min = num[0];
        int len = num.length;
        for (int i=1;i<len;i++) {
        	if (num[i] < min) min = num[i];
        }
        return min;
    }
    */
	
	public int findMin(int[] num) {
		if (num.length == 0) return 0;
		int left = 0, right = num.length - 1;
		int mid = 0;
		if (num[left] <= num[right]) return num[left]; 
		while (left != (right - 1)) {
			mid = (left + right) / 2;
			if (num[left] < num[mid]) left = mid;
			else right = mid;
		}
		return Math.min(num[left], num[right]);
	}
}
