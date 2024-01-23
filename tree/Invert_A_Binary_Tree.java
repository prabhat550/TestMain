package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Invert_A_Binary_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(10);

		node.left = new TreeNode(5);
		node.right = new TreeNode(15);

		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(7);
		node.right.left = new TreeNode(12);
		node.right.right = new TreeNode(17);

		inOrderTraversal(node);
		// TreeNode result = invertTree_Recursive(node);
		TreeNode result = invertTree_Iterative(node);
		System.out.println();
		inOrderTraversal(result);

	}
	
    public static TreeNode invertTree_Recursive(TreeNode root) {
        if (root == null)
            return null;
        swap(root);
        invertTree_Recursive(root.left);
        invertTree_Recursive(root.right);
        return root;
    }
	
	public static TreeNode invertTree_Iterative(TreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			swap(node);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		return root;
	}
    
	public static void swap(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.value + " ");
		inOrderTraversal(node.right);
	}

}
