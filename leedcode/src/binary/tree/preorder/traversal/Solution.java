package binary.tree.preorder.traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> res = new ArrayList<Integer>();
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) return res;
		res.add(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
        return res;
    }
}
