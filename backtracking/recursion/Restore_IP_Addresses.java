package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses {

	public static void main(String[] args) {

		String s = "25525511135";
		List<String> result = restoreIpAddresses(s);
		System.out.println(result);
		String s1 = "abcde";
		System.out.println(s1.substring(0, 1));

	}

	public static List<String> restoreIpAddresses(String s) {

		List<String> result = new ArrayList<String>();
		int n = s.length();
		for (int i = 1; i < n && i < 4; i++) {
			String first = s.substring(0, i);
			if (!isValid(first))
				continue;
			for (int j = 1; i + j < n && j < 4; j++) {
				String second = s.substring(i, i + j);
				if (!isValid(second))
					continue;
				for (int k = 1; i + j + k < n && k < 4; k++) {
					String third = s.substring(i + j, i + j + k);
					String fourth = s.substring(i + j + k);
					if (!isValid(third) || !isValid(fourth))
						continue;
					result.add(first + "." + second + "." + third + "." + fourth);
				}
			}
		}
		return result;
	}

	public static boolean isValid(String s) {

		if (s.length() > 3)
			return false;

		if (s.startsWith("0") && s.length() > 1)
			return false;

		int val = Integer.parseInt(s);

		return val >= 0 && val <= 255;
	}

}
