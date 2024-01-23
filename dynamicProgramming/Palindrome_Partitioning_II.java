package com.dp;

public class Palindrome_Partitioning_II {

    public static void main(String[] args) {

        int result_minCut = minCut("aab");
        System.out.println(result_minCut);

    }

    public static int minCut(String s) {

        if (s == null || s.length() == 0)
            return 0;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                    dp[i][j] = true;
                }
            }
        }

        int[] pal = new int[s.length()];
        pal[0] = 0;

        for (int j = 1; j < s.length(); j++) {
            int min = Integer.MAX_VALUE;
            if (dp[0][j]) {
                pal[j] = 0;
            } else {
                for (int i = j; i >= 1; i--) {
                    if (dp[i][j]) {
                        min = Math.min(pal[i - 1], min);
                    }
                }
                pal[j] = min + 1;
            }
        }
        return pal[s.length() - 1];
    }
}
