package com.two.pointer;

import java.util.Arrays;
import java.util.HashSet;

public class Pairs_Of_Number_Equal_To_k_Exist_In_An_Array {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 4, 4, 5 };
        boolean result_1 = pairOfNumberEqualToKInAnArray_TwoPointer(array, 8);
        System.out.println(result_1);

        boolean result_2 = pairOfNumberEqualToKInAnArray_Hashing(array, 8);
        System.out.println(result_2);

    }

    // For this approach the array should be SORTED
    public static boolean pairOfNumberEqualToKInAnArray_TwoPointer(int[] array, int sum) {

        Arrays.sort(array);
        int start_pointer = 0;
        int end_pointer = array.length - 1;
        int addition = 0;
        while (start_pointer < end_pointer) {
            addition = array[start_pointer] + array[end_pointer];
            if (addition == sum)
                return true;
            if (addition > sum)
                end_pointer--;
            if (addition < sum)
                start_pointer++;
        }
        return false;
    }

    // This approach is for array which is UNSORTED
    public static boolean pairOfNumberEqualToKInAnArray_Hashing(int[] array, int sum) {

        HashSet<Integer> complement = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int comp = sum - array[i];

            if (complement.contains(comp)) {
                System.out.println("Pair with given sum " + sum + " is (" + array[i] + ", " + comp + ")");
                return true;
            } else {
                complement.add(array[i]);
            }
        }
        return false;
    }

}
