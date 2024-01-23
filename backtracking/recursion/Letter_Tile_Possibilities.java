package com.backtracking.recursion;

public class Letter_Tile_Possibilities {

    public static void main(String[] args) {
        
        
        int result_numTilePossibilities = numTilePossibilities("AAB");
        System.out.println(result_numTilePossibilities);
        
    }

    public static int result = 0;

    public static int numTilePossibilities(String tiles) {

        if (tiles == null) {
            return 0;
        }

        int[] array = new int[26];

        for (char c : tiles.toCharArray()) {
            array[c - 'A']++;
        }

        helperMethod(array);
        return result;

    }

    public static void helperMethod(int[] array) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == 0)
                continue;
            result++;
            array[i]--;
            helperMethod(array);
            array[i]++;

        }

    }

}
