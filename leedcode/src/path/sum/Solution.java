package path.sum;

public class Solution {
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.left == null && root.right == null && root.val == sum ) return true;
		//if (root.val > sum) return false;
		if (root.left != null && hasPathSum(root.left, sum - root.val)) return true;
		if (root.right != null && hasPathSum(root.right, sum - root.val)) return true;
		return false;
    }
	
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);*/
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		System.out.println(hasPathSum(root, -5));
	}
}
