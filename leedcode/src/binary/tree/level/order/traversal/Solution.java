package binary.tree.level.order.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		int curNodeNum = 1;
		int nextNodeNum = 0;
		List<Integer> curList = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			curList.add(node.val);
			curNodeNum--;
			if (node.left != null) {
				nextNodeNum++;
				q.add(node.left);
			}
			if (node.right != null) {
				nextNodeNum++;
				q.add(node.right);
			}
			
			if (curNodeNum == 0) {
				curNodeNum = nextNodeNum;
				nextNodeNum = 0;
				res.add(curList);
				curList = new ArrayList<Integer>();
			}
		}
        return res;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(11);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(21);
		root.right.left = new TreeNode(24);
		root.right.right = new TreeNode(25);
		
		List<List<Integer>> res = levelOrder(root);
		for (int i=0;i<res.size();i++) {
			List<Integer> lst = res.get(i);
			for (int j=0;j<lst.size();j++) {
				int t = lst.get(j);
				System.out.print(t + ",");
			}
			System.out.println();
		}
	}
}
