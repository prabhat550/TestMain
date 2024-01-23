package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Zigzag_Level_Order_Traversal {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);

		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer>> result = zigzagLevelOrder(root);
		System.out.println(result);

	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			List<Integer> l1 = new ArrayList<>();
			while (!s1.isEmpty()) {
				TreeNode node = s1.pop();
				l1.add(node.value);
				if (node.left != null)
					s2.add(node.left);
				if (node.right != null)
					s2.add(node.right);
			}
			if (!l1.isEmpty())
				result.add(l1);
			List<Integer> l2 = new ArrayList<>();
			while (!s2.isEmpty()) {
				TreeNode node = s2.pop();
				l2.add(node.value);
				if (node.right != null)
					s1.add(node.right);
				if (node.left != null)
					s1.add(node.left);
			}
			if (!l2.isEmpty())
				result.add(l2);
		}
		return result;
	}

}
