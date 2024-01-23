package com.two.pointer;

public class Find_The_Index_Of_The_First_Occurrence_In_A_String {

	public static void main(String[] args) {

		int result = strStr("doingleetcodedoingleetcode", "leet");
		System.out.println(result);

	}

	public static int strStr(String haystack, String needle) {
		
		if (needle.length() == 0)
			return 0;
		if (needle.length() > haystack.length())
			return -1;
		int n = needle.length();
		int h = haystack.length();
		for (int i = 0; i <= h - n; i++) {
			int j = 0;
			while (j < n && needle.charAt(j) == haystack.charAt(i + j)) {
				j++;
				if (j == n) {
					return i;
				}
			}
		}
		return -1;
	}
}


