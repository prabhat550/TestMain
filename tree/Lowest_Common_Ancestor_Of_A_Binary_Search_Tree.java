package com.tree;

public class Lowest_Common_Ancestor_Of_A_Binary_Search_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(5);

		node.left = new TreeNode(2);
		node.right = new TreeNode(8);

		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(4);
		node.right.left = new TreeNode(7);
		node.right.right = new TreeNode(8);

		node.left.right.left = new TreeNode(3);

		TreeNode result = lowestCommonAncestor(node, node.left.left, node.left.right.left);
		System.out.println(result.value);

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;

		if (p.value < root.value && q.value < root.value) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.value > root.value && q.value > root.value) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}

}
