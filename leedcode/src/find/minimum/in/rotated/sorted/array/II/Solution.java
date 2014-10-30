package find.minimum.in.rotated.sorted.array.II;

public class Solution {
	public int findMin(int[] num) {
		if (num.length == 0) return 0;
		int left = 0;
		int right = num.length - 1;
		if (num[left] > num[right]) {
			while (left != (right - 1) ) {
				int mid = (left + right) / 2;
				if (num[left] <= num[mid]) left = mid;
				else right = mid;
			}
			return Math.min(num[left], num[right]);
		} else if ( num[left] == num[right] ) {
			int min = num[0];
			for (int i=1;i<num.length;i++) {
				if (min > num[i]) min = num[i];
			}
			return min;
		}
		return num[0];
	}
}
