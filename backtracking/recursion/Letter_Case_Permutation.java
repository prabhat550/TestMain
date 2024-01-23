package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Letter_Case_Permutation {

    public static void main(String[] args) {

        List<String> result_letterCasePermutation = letterCasePermutation("a1b2");
        System.out.println(result_letterCasePermutation);
    }

    public static List<String> letterCasePermutation(String s) {

        List<String> result = new ArrayList<String>();
        helperMethod(result, "", s, 0);

        return result;
    }

    public static void helperMethod(List<String> result, String current_string, String s, int index) {

        if (s.length() == current_string.length()) {
            result.add(current_string);
            return;
        }
        
        char c = s.charAt(index);
        if (c >= '0' && c <= '9') {

            helperMethod(result, current_string + s.charAt(index), s, index + 1);

        } else {
            helperMethod(result, current_string + Character.toLowerCase(s.charAt(index)), s, index + 1);
            helperMethod(result, current_string + Character.toUpperCase(s.charAt(index)), s, index + 1);
        }

    }

}