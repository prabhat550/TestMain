package com.tree;

public class Binary_Tree_Maximum_Path_Sum {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(-10);

		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		int result = maxPathSum(root);
		System.out.println(result);

	}

	public static int maxPathSum(TreeNode root) {
		int[] maxValue = new int[1];
		maxValue[0] = Integer.MIN_VALUE;
		helperMethod(root, maxValue);
		return maxValue[0];
	}

	private static int helperMethod(TreeNode root, int[] maxValue) {
		if (root == null)
			return 0;
		int left = Math.max(0, helperMethod(root.left, maxValue));
		int right = Math.max(0, helperMethod(root.right, maxValue));
		maxValue[0] = Math.max(maxValue[0], root.value + left + right);
		return root.value + Math.max(left, right);
	}

}
