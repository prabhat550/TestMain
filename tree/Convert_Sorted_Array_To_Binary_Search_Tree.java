package com.tree;

public class Convert_Sorted_Array_To_Binary_Search_Tree {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 5, 7, 9 };
		TreeNode result = sortedArrayToBST(array);
		System.out.println(result.value);
		inOrderTraversal(result);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return helperMethod(nums, 0, nums.length - 1);
	}

	private static TreeNode helperMethod(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int mid_point = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[mid_point]);
		node.left = helperMethod(nums, left, mid_point - 1);
		node.right = helperMethod(nums, mid_point + 1, right);
		return node;
	}

	public static void inOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.value + " ");
		inOrderTraversal(root.right);
	}

}
