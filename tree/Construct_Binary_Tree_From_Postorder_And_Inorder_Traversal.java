package com.tree;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_From_Postorder_And_Inorder_Traversal {

	public static void main(String[] args) {

		int[] postorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };

		TreeNode result = buildTree(inorder, postorder);
		System.out.println(result);
		inOrderTraversal(result);
	}

	private static Map<Integer, Integer> map = new HashMap<>();
	private static int postIndex = 0;

	// Inorder = Left Root Right
	// Postorder = Left Right Root
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length != postorder.length)
			return null;
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		postIndex = postorder.length - 1;
		return helperMethod(inorder, postorder, 0, inorder.length - 1);
	}

	private static TreeNode helperMethod(int[] inorder, int[] postorder, int start, int end) {
		if (start > end)
			return null;
		TreeNode root = new TreeNode(postorder[postIndex--]);
		if (start == end)
			return root;
		int index = map.get(root.value);
		root.right = helperMethod(inorder, postorder, index + 1, end);
		root.left = helperMethod(inorder, postorder, start, index - 1);
		return root;
	}

	private static void inOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.value + " ");
		inOrderTraversal(root.right);
	}

}
