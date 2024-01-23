package com.tree;

public class Merge_Two_Binary_Tree {

	public static void main(String[] args) {

		TreeNode treeNode_1 = new TreeNode(1);
		treeNode_1.left = new TreeNode(3);
		treeNode_1.right = new TreeNode(2);
		treeNode_1.left.left = new TreeNode(5);

		TreeNode treeNode_2 = new TreeNode(2);
		treeNode_2.left = new TreeNode(1);
		treeNode_2.right = new TreeNode(3);
		treeNode_2.left.right = new TreeNode(4);
		treeNode_2.right.right = new TreeNode(7);

		TreeNode result = mergeTrees(treeNode_1, treeNode_2);
		System.out.println(result);

	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return null;
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
		TreeNode sum = new TreeNode(t1.value + t2.value);
		sum.left = mergeTrees(t1.left, t2.left);
		sum.right = mergeTrees(t1.right, t2.right);
		return sum;
	}

}
