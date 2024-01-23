package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Sum_Root_To_Leaf_Numbers {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		int result = sumNumbers(root);
		System.out.println(result);

	}

	public static int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<Integer> numbers = new ArrayList<>();
		getNumber(root, 0, numbers);
		return numbers.stream().mapToInt(i -> i.intValue()).sum();
	}

	public static void getNumber(TreeNode root, int number, List<Integer> numbers) {
		if (root == null)
			return;
		number *= 10;
		number += root.value;
		if(root.left == null && root.right == null)
			numbers.add(number);
		if(root.left != null)
			getNumber(root.left, number, numbers);
		if(root.right != null)
			getNumber(root.right, number, numbers);
	}

}
