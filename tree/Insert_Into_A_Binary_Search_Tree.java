package com.tree;

public class Insert_Into_A_Binary_Search_Tree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(2);
		root.right = new TreeNode(7);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		TreeNode result = insertIntoBST(root, 5);
		System.out.println(result);

	}

	public static TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		TreeNode curr = root;
		while (true) {
			if (curr.value <= val) {
				if (curr.right != null) {
					curr = curr.right;
				} else {
					curr.right = new TreeNode(val);
					break;
				}
			} else {
				if (curr.left != null) {
					curr = curr.left;
				} else {
					curr.left = new TreeNode(val);
					break;
				}
			}
		}
		return root;
	}

}
