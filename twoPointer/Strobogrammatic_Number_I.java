package com.two.pointer;

import java.util.HashMap;
import java.util.Map;

public class Strobogrammatic_Number_I {

	public static void main(String[] args) {
		
		boolean result = isStrobogrammatic("969");	
		System.out.println(result);
	}

	public static boolean isStrobogrammatic(String num) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('0', '0');
		map.put('1', '1');
		map.put('8', '8');
		int l = 0, r = num.length() - 1;
		while (l <= r) {
			if (!map.containsKey(num.charAt(l)))
				return false;
			if (map.get(num.charAt(l)) != num.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

}
