package balanced.binary.tree;

public class Solution {
	
	public int calDeep(TreeNode root, int deep) {
		if (root == null) return deep - 1;
		int leftDeep = deep;
		if (root.left != null) leftDeep = calDeep(root.left, deep + 1);
		int rightDeep = deep;
		if (root.right != null) rightDeep = calDeep(root.right, deep + 1);
		if (leftDeep == -1 || rightDeep == -1 ) return -1;
		int abs = Math.abs( (leftDeep - rightDeep) );
		if (abs <= 1) return Math.max(leftDeep, rightDeep);
		else return -1;
	}
	
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
        return calDeep(root,1) != -1;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(1);
		
		Solution s = new Solution();
		System.out.println(s.calDeep(root, 1));
		System.out.println(s.isBalanced(root));
	}
	/**
	 * public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
 
		if (getHeight(root) == -1)
			return false;
 
		return true;
	}
 
	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
 
		int left = getHeight(root.left);
		int right = getHeight(root.right);
 
		if (left == -1 || right == -1)
			return -1;
 
		if (Math.abs(left - right) > 1) {
			return -1;
		}
 
		return Math.max(left, right) + 1;
 
	}
	 */
}
