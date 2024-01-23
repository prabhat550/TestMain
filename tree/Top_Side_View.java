package com.tree;

import java.util.List;

public class Top_Side_View {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);

		List<Integer> result = topSideView(node);
		System.out.println(result);

	}

	private static List<Integer> topSideView(TreeNode node) {
		
		
		
		return null;
	}

}
