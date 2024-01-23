package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Of_A_String_Without_Any_Duplicates {

    
    public static void main(String[] args) {

        String s = "abq";
        List<String> result_permutation = permutation(s);
        System.out.println(result_permutation);
        
    }

    public static List<String> permutation(String s) {

        List<String> result = new ArrayList<>();
        char[] array = s.toCharArray();
        boolean[] visited = new boolean[array.length];
        helperMethod(result, array, visited, new StringBuilder());
        return result;

    }

    private static void helperMethod(List<String> result, char[] array, boolean[] visited, StringBuilder sb) {

        if (sb.length() == array.length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < array.length; i++) {

            if (visited[i])
                continue;

            visited[i] = true;
            sb.append(array[i]);
            helperMethod(result, array, visited, sb);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);

        }

    }
    
    
}
