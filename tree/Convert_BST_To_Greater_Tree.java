package com.tree;

import java.util.Stack;

public class Convert_BST_To_Greater_Tree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(1);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);

		root.left.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(8);

		TreeNode result_Recursive = convertBST_Recursive(root);
		System.out.println(result_Recursive);

		TreeNode result_Iterative = convertBST_Iterative(root);
		System.out.println(result_Iterative);

	}

	private static int sum_Recursive = 0;
	
	private static int sum_Iterative = 0;
	
	// Reverse Inorder Traversal - Right Root Left
	public static TreeNode convertBST_Recursive(TreeNode root) {
		if (root == null)
			return root;

		convertBST_Recursive(root.right);
		sum_Recursive += root.value;
		root.value = sum_Recursive;
		convertBST_Recursive(root.left);
		return root;
	}

	public static TreeNode convertBST_Iterative(TreeNode root) {
		if (root == null)
			return root;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.add(node);
				node = node.right;
			}
			node = stack.pop();
			sum_Iterative += node.value;
			node.value = sum_Iterative;
			node = node.left;
		}
		return root;
	}

}
