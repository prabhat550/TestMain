package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Add_One_Row_To_Tree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(2);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(1);

//		TreeNode result_Recursive = addOneRow_Recursive(root, 1, 2);
//		System.out.println(result_Recursive);

		TreeNode result_Iterative = addOneRow_Iterative(root, 1, 4);
		System.out.println(result_Iterative);

	}

	public static TreeNode addOneRow_Recursive(TreeNode root, int val, int depth) {
		if (root == null)
			return root;
		if (depth == 1) {
			TreeNode node = new TreeNode(val);
			node.left = root;
			return node;
		}
		insert(root, val, depth, 1);
		return root;
	}

	private static void insert(TreeNode root, int val, int depth, int curr_depth) {
		if (root == null)
			return;
		if (curr_depth == depth - 1) {
			TreeNode temp = root.left;
			root.left = new TreeNode(val);
			root.left.left = temp;
			temp = root.right;
			root.right = new TreeNode(val);
			root.right.right = temp;
		} else {
			insert(root.left, val, depth, curr_depth + 1);
			insert(root.right, val, depth, curr_depth + 1);
		}
	}

	public static TreeNode addOneRow_Iterative(TreeNode root, int val, int depth) {
		if (root == null)
			return root;
		if (depth == 1) {
			TreeNode node = new TreeNode(val);
			node.left = root;
			return node;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int curr_depth = 1;
		while (curr_depth < depth - 1) {
			Queue<TreeNode> temp = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeNode curr = queue.poll();
				if (curr.left != null)
					temp.add(curr.left);
				if (curr.right != null)
					temp.add(curr.right);
			}
			curr_depth++;
			queue = temp;
		}
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode temp = node.left;
			node.left = new TreeNode(val);
			node.left.left = temp;
			temp = node.right;
			node.right = new TreeNode(val);
			node.right.right = temp;
		}
		return root;
	}

}
