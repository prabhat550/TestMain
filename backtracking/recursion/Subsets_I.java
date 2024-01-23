package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets_I {

    
    public static void main(String[] args) {

        int[] array = new int[] { 1, 2, 3 };

        List<List<Integer>> result_subsets = subsets(array);
        System.out.println(result_subsets);

    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        helperMethod(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private static void helperMethod(int[] array, List<List<Integer>> result, List<Integer> list, int index) {

        result.add(new ArrayList<Integer>(list));

        for (int i = index; i < array.length; i++) {
            list.add(array[i]);
            helperMethod(array, result, list, i + 1);
            list.remove(list.size() - 1);
        }

    }

}
