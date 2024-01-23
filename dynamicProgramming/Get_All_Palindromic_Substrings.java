package com.dp;

import java.util.ArrayList;
import java.util.List;

public class Get_All_Palindromic_Substrings {

    public static void main(String[] args) {

        
        List<String> result = getAllPalindromicSubstring("abccbc");
        System.out.println(result);

    }

    private static List<String> getAllPalindromicSubstring(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];

        List<String> result = new ArrayList<>();

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else if (dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }

                if (dp[i][j]) {
                    result.add(s.substring(i, j + 1));
                }
            }
        }

        return result;
    }

}
