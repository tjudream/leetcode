package binary.tree.inorder.traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> res = new ArrayList<Integer>();
	public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}
