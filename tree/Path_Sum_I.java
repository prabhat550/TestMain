package com.tree;

public class Path_Sum_I {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(5);

		node.left = new TreeNode(4);
		node.right = new TreeNode(8);

		node.left.left = new TreeNode(11);
		node.right.left = new TreeNode(13);
		node.right.right = new TreeNode(4);

		node.left.left.left = new TreeNode(7);
		node.left.left.right = new TreeNode(2);
		node.right.right.right = new TreeNode(1);
		
		boolean result = hasPathSum_Recursive(node, 22);
		System.out.println(result);

	}

	public static boolean hasPathSum_Recursive(TreeNode root, int targetSum) {

		if (root == null && targetSum != 0)
			return false;

		if (root == null && targetSum == 0)
			return true;

		return hasPathSum_Recursive(root.left, targetSum - root.value)
				|| hasPathSum_Recursive(root.right, targetSum - root.value);

	}

}
