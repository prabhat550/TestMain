package com.tree;

public class Longest_ZigZag_Path_In_A_Binary_Tree {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		int result = longestZigZag(root);

	}

	public static int longestZigZag(TreeNode root) {
		return 1;
	}

}
