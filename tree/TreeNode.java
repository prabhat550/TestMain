package com.tree;

public class TreeNode {

	int value;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int value) {
		super();
		this.value = value;
	}

	public TreeNode(int value, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

}
