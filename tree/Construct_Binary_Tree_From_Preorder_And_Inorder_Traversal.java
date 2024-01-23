package com.tree;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal {

	public static void main(String[] args) {

		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };

		TreeNode result = buildTree(preorder, inorder);
		System.out.println(result);
		inOrderTraversal(result);
	}

	private static Map<Integer, Integer> map = new HashMap<>();
	private static int preIndex = 0;

	// Inorder = Left Root Right
	// Preorder = Root Left Right
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length)
			return null;
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helperMethod(preorder, inorder, 0, inorder.length - 1);
	}

	private static TreeNode helperMethod(int[] preorder, int[] inorder, int start, int end) {
		if (start > end)
			return null;
		TreeNode root = new TreeNode(preorder[preIndex++]);
		if (start == end)
			return root;
		int index = map.get(root.value);
		root.left = helperMethod(preorder, inorder, start, index - 1);
		root.right = helperMethod(preorder, inorder, index + 1, end);
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
