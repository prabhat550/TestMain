package com.tree;

public class Subtree_Of_Another_Tree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);

		root.left = new TreeNode(4);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);

		TreeNode subRoot = new TreeNode(4);

		subRoot.left = new TreeNode(1);
		subRoot.right = new TreeNode(2);

		boolean result = isSubtree(root, subRoot);
		System.out.println(result);

	}

	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (subRoot == null)
			return false;
		else if (isSameTree(root, subRoot))
			return true;
		else
			return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private static boolean isSameTree(TreeNode root, TreeNode subRoot) {
		if (root == null || subRoot == null)
			return root == null && subRoot == null;
		else if (root.value == subRoot.value)
			return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
		return false;
	}

}
