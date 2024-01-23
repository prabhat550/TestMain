package com.stack;

import java.util.Stack;

public class Daily_Temperatures {

	public static void main(String[] args) {

		int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] result = dailyTemperatures(temperatures);
		System.out.println(result);

	}

	public static int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] nge = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = temperatures.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				nge[i] = 0;
			} else {
				nge[i] = stack.peek() - i;
			}
			stack.push(i);
		}
		return nge;
	}

}
