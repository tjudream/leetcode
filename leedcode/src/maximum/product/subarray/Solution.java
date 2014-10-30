package maximum.product.subarray;
/**
 * 
 * @author mengxiansen
 * 分3种情况：
 * (1)无0且负数为偶数个，全部乘在一起
 * (2)无0且负数为奇数个，最左边的负数的所有右边的数的乘积A，最右边的负数的所有左边的数的乘积B，返回A、B中比较大的
 * (3)有0,已0为边界，分成若干个情况(1)、}(2)找出最大的
 * ]
 */
/**
 * 
 * @author mengxiansen
 * 一步一步的乘，每次记录最大值和最小值
 */
public class Solution {
	
	public int maxProduct(int[] A) {
        if (A.length == 0) return 0;
        int max = A[0];
        int min = A[0];
        int res = A[0];
        for (int i=1;i<A.length;i++) {
        	int tmp_max = max * A[i];
        	int tmp_min = min * A[i];
        	min = Math.min(Math.min(tmp_max, tmp_min), A[i]);
        	max = Math.max(Math.max(tmp_max, tmp_min), A[i]);
        	res = max > res ? max : res;
        }
        return res;
    }
}
