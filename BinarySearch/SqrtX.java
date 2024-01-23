package com.binary.search;

public class SqrtX {

	public static void main(String[] args) {

		int result_mySqrt_Recursive = mySqrt_Recursive(8);
		System.out.println(result_mySqrt_Recursive);

	}

	public static int mySqrt_Recursive(int x) {

		int sqrt = (int) helperMethod(x, 0, x);
		return sqrt;

	}

	private static long helperMethod(long target, long start, long end) {

		if (start > end)
			return -1;
		long mid = start + (end - start) / 2;
		long square = mid * mid;
		if (square == target) {
			return mid;
		} else if (square > target & (mid - 1) * (mid - 1) < target) {
			return mid - 1;
		} else if (square < target && (mid + 1) * (mid + 1) > target) {
			return mid;
		} else if (square < target) {
			return helperMethod(target, mid + 1, end);
		} else if (square > target) {
			return helperMethod(target, start, mid - 1);
		}
		return -1;
	}

}
