package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Boundary_Traversal_Of_Binary_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(3);
		node.right.right = new TreeNode(8);

		node.left.left.right = new TreeNode(4);
		node.right.right.left = new TreeNode(9);

		node.left.left.right.left = new TreeNode(5);
		node.left.left.right.right = new TreeNode(6);
		node.right.right.left.left = new TreeNode(10);
		node.right.right.left.right = new TreeNode(11);

		List<Integer> result = boundaryLevelTraversal(node);
		System.out.println(result);

	}

	public static List<Integer> boundaryLevelTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (!isLeafNode(root)) {
			result.add(root.value);
		}
		addLeftBoundary(root, result);
		addLeavesNodes(root, result);
		addRightBoundary(root, result);
		return result;
	}

	private static void addLeftBoundary(TreeNode root, List<Integer> result) {
		TreeNode curr = root.left;
		while (curr != null) {
			if (!isLeafNode(curr))
				result.add(curr.value);
			if (curr.left != null)
				curr = curr.left;
			else
				curr = curr.right;
		}
		return;
	}

	private static void addRightBoundary(TreeNode root, List<Integer> result) {
		TreeNode curr = root.right;
		List<Integer> list = new ArrayList<Integer>();
		while (curr != null) {
			if (!isLeafNode(curr)) {
				list.add(curr.value);
			}
			if (curr.right != null) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			result.add(list.get(i));
		}
		return;
	}

	private static void addLeavesNodes(TreeNode root, List<Integer> result) {
		if (isLeafNode(root)) {
			result.add(root.value);
			return;
		}
		if (root.left != null)
			addLeavesNodes(root.left, result);
		if (root.right != null)
			addLeavesNodes(root.right, result);
	}

	private static boolean isLeafNode(TreeNode root) {
		if (root.left == null && root.right == null)
			return true;
		return false;
	}

}
