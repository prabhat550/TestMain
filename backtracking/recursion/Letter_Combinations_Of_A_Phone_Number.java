package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Letter_Combinations_Of_A_Phone_Number {

	public static void main(String[] args) {

		List<String> result_letterCombinations_Approach1 = letterCombinations_Approach1("23");
		System.out.println(result_letterCombinations_Approach1);

		List<String> result_letterCombinations_Approach2 = letterCombinations_Approach2("23");
		System.out.println(result_letterCombinations_Approach2);

	}

	public static List<String> letterCombinations_Approach1(String digits) {

		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return result;

		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		helperMethod(result, "", digits, 0, mapping);

		return result;
	}

	public static void helperMethod(List<String> result, String current, String digits, int index, String[] mapping) {

		if (index == digits.length()) {
			result.add(current);
			return;
		}

		String letters = mapping[digits.charAt(index) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			helperMethod(result, current + letters.charAt(i), digits, index + 1, mapping);
		}
	}

	public static List<String> letterCombinations_Approach2(String digits) {

		LinkedList<String> output_array = new LinkedList<>();

		if (digits.length() == 0)
			return output_array;

		output_array.add("");
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		for (int i = 0; i < digits.length(); i++) {
			int index = Character.getNumericValue(digits.charAt(i));
			while (output_array.peek().length() == i) {
				String permutation = output_array.remove();
				for (char c : mapping[index].toCharArray()) {
					output_array.add(permutation + c);
				}
			}
		}
		return output_array;
	}

}
