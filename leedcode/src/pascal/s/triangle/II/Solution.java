package pascal.s.triangle.II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static List<Integer> getRow(int rowIndex) {
		List reslst = new ArrayList<Integer>();
		int res[] = new int[rowIndex+1];
		if ( rowIndex < 0 ) return reslst;
		res[0] = 1;
		for ( int i=1; i<rowIndex + 1; i++) {
			res[i] = res[i-1];
			int pre = res[0];
			for (int j=1;j<i;j++) {
				int cur = res[j];
				res[j] = pre + res[j];
				pre = cur;
			}
		}
		for (int i=0;i<rowIndex + 1;i++) {
			reslst.add(res[i]);
		}
		return reslst;
    }
	
	
	public static void main(String[] args) {
		List<Integer> lst = getRow(5);
		System.out.print("[");
		for (int j=0;j<lst.size() - 1;j++) {
			System.out.print(lst.get(j) + ",");
		}
		System.out.println(lst.get(lst.size() - 1) + "]");
		
	}
}
