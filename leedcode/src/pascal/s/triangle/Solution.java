package pascal.s.triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<List<Integer>> generate(int numRows) {
		List res = new ArrayList<List<Integer>>();
		if (numRows < 1) return res;
		List lst1 = new ArrayList<Integer>();
		lst1.add(1);
		res.add(lst1);
		for (int i=0;i<numRows - 1;i++) {
			List tmplst = new ArrayList<Integer>();
			List lastlst = (List) res.get(i);
			int len = lastlst.size();
			tmplst.add(lastlst.get(0));
			for (int j=1;j<len;j++) {
				int val = (Integer)lastlst.get(j - 1) + (Integer)lastlst.get(j);
				tmplst.add(val);
			}
			tmplst.add(lastlst.get(len - 1));
			res.add(tmplst);
		}
        return res;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> res = generate(5);
		for (int i=0;i<res.size();i++) {
			System.out.print("第"+i+"层: [");
			List<Integer> lst = res.get(i);
			for (int j=0;j<lst.size() - 1;j++) {
				System.out.print(lst.get(j) + ",");
			}
			System.out.println(lst.get(lst.size() - 1) + "]");
		}
	}
}
