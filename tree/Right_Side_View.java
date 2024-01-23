package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Right_Side_View {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		
		node.right.right.left = new TreeNode(9);

		List<Integer> result = rightSideView(node);
		System.out.println(result);

	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				root = queue.poll();
				if (i == 0)
					result.add(root.value);
				if (root.right != null)
					queue.offer(root.right);
				if (root.left != null)
					queue.offer(root.left);
			}
		}
		return result;
	}
}
