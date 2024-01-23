package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(5);

		node.left = new TreeNode(4);
		node.right = new TreeNode(8);

		node.left.left = new TreeNode(11);
		node.right.left = new TreeNode(13);
		node.right.right = new TreeNode(4);

		node.left.left.left = new TreeNode(7);
		node.left.left.right = new TreeNode(2);
		node.right.right.left = new TreeNode(5);
		node.right.right.right = new TreeNode(1);

		List<List<Integer>> result = hasPathSum(node, 22);
		System.out.println(result);

	}

	public static List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		helperMethod(root, targetSum, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private static void helperMethod(TreeNode root, int targetSum, int currentSum, List<Integer> list,
			List<List<Integer>> result) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			currentSum += root.value;
			if (targetSum == currentSum) {
				List<Integer> base = new ArrayList<>(list);
				base.add(root.value);
				result.add(base);
			}
		}
		list.add(root.value);
		helperMethod(root.left, targetSum, currentSum + root.value, list, result);
		helperMethod(root.right, targetSum, currentSum + root.value, list, result);
		list.remove(list.size() - 1);
		return;
	}

}
