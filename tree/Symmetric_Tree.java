package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(2);

		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(4);
		node.right.left = new TreeNode(4);
		node.right.right = new TreeNode(3);

		boolean result_Recursive = isSymmetric_Recursive(node);
		System.out.println(result_Recursive);
		boolean result_Iterative = isSymmetric_Iterative(node);
		System.out.println(result_Iterative);
		
	}

	public static boolean isSymmetric_Recursive(TreeNode root) {
		if (root == null)
			return true;
		return isMirror(root, root);
	}

	private static boolean isMirror(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.value != q.value)
			return false;
		return isMirror(p.left, q.right) && isMirror(p.right, q.left);
	}

	public static boolean isSymmetric_Iterative(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root.left);
		queue.add(root.right);
		while (!queue.isEmpty()) {
			TreeNode tLeft = queue.poll();
			TreeNode tRight = queue.poll();
			if (tLeft == null && tRight == null)
				continue;
			if (tLeft == null || tRight == null)
				return false;
			if (tLeft.value != tRight.value)
				return false;
			queue.add(tLeft.left);
			queue.add(tRight.right);
			queue.add(tRight.left);
			queue.add(tLeft.right);
		}
		return true;
	}

}
