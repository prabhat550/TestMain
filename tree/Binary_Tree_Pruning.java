package com.tree;

public class Binary_Tree_Pruning {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(1);
		node.right = new TreeNode(0);

		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(1);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(1);

		node.left.left.left = new TreeNode(0);

		TreeNode result = pruneTree(node);
		System.out.println(result);

	}

	public static TreeNode pruneTree(TreeNode root) {
		
		return containsOne(root) ? root : null;
	}

	private static boolean containsOne(TreeNode root) {
		
		if (root == null)
			return false;
		
		// Check if any node in the left subtree contains a 1.
		boolean leftContainsOne = containsOne(root.left);

		// Check if any node in the right subtree contains a 1.
		boolean rightContainsOne = containsOne(root.right);

		// If the left subtree does not contain a 1, prune the subtree.
		if (!leftContainsOne)
			root.left = null;

		// If the right subtree does not contain a 1, prune the subtree.
		if (!rightContainsOne)
			root.right = null;

		// Return true if the current node, its left or right subtree contains a 1.
		return root.value == 1 || leftContainsOne || rightContainsOne;
	}

}
