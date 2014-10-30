package minimum.depth.of.binary.tree;

public class Solution {
	
	public int calminDepth(TreeNode node, int deep) {
		if (node.left == null && node.right == null) return deep;
		int leftDeep = Integer.MAX_VALUE;
		int rightDeep = Integer.MAX_VALUE;
		if (node.left != null) leftDeep = calminDepth(node.left, deep + 1);
		if (node.right != null) rightDeep = calminDepth(node.right, deep + 1);
		return Math.min(leftDeep, rightDeep);
	}
	
	public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return calminDepth(root, 1);
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		
		Solution sol = new Solution();
		System.out.println(sol.minDepth(root));
	}
}
