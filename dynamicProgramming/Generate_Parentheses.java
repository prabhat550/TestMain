package com.dp;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

	public static void main(String[] args) {
		List<String> result_generateParenthesis = generateParenthesis(3);
		System.out.println(result_generateParenthesis);
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		backtracking_HelperMethod(list, "", 0, 0, n);
		return list;
	}

	public static void backtracking_HelperMethod(List<String> list, String s, int start, int end, int max) {
		if (s.length() == max * 2) {
			list.add(s);
		}
		if (start < max)
			backtracking_HelperMethod(list, s + "(", start + 1, end, max);
		if (end < start)
			backtracking_HelperMethod(list, s + ")", start, end + 1, max);
	}

}
