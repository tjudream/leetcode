package two.sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers.length < 2) return null;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(numbers[0], 1);
		for (int i=1;i<numbers.length;i++) {
			int tmp = target - numbers[i];
			if (map.containsKey(tmp)) {
				return new int[]{map.get(tmp), i + 1};
			}
			map.put(numbers[i], i + 1);
		}
		return null;
    }
}
