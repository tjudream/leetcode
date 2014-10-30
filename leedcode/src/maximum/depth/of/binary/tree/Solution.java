package maximum.depth.of.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public int maxDeep(TreeNode node, int deep) {
		int leftdeep = deep;
		int rightdeep = deep;
		if (node.left != null) leftdeep = maxDeep(node.left, deep + 1);
		if (node.right != null) rightdeep = maxDeep(node.right, deep + 1);
		if (leftdeep > rightdeep) return leftdeep;
		else return rightdeep;
	}
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
        return maxDeep(root, 1);
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(6);
		Solution s = new Solution();
		System.out.println(s.maxDepth(root));
	}
}
