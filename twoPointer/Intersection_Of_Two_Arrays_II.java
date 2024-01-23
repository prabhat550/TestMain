package com.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection_Of_Two_Arrays_II {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] result = intersect(nums1, nums2);
		System.out.println(result);

	}

	public static int[] intersect(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		List<Integer> result = new ArrayList<>();
		int nums1Length = nums1.length;
		int nums2Length = nums2.length;

		int i = 0;
		int j = 0;

		while (i < nums1Length && j < nums2Length) {
			if(nums1[i] == nums2[j]) {
				result.add(nums1[i]);
				i++;
				j++;
			}else if(nums1[i] > nums2[j]) {
				j++;
			}else {
				i++;
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

}
