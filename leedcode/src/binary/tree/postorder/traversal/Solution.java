package binary.tree.postorder.traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> res = new ArrayList<Integer>();
	public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}
