package com.linked.list;

import java.util.Stack;

public class Palindromic_Linked_List {

	public static void main(String[] args) {

		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(3);
		list1.next.next.next = new ListNode(4);
		list1.next.next.next.next = new ListNode(5);
		list1.next.next.next.next.next = new ListNode(3);
		list1.next.next.next.next.next.next = new ListNode(4);
		list1.next.next.next.next.next.next.next = new ListNode(7);
		list1.next.next.next.next.next.next.next.next = new ListNode(6);
		list1.next.next.next.next.next.next.next.next.next = new ListNode(7);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(2);
		list2.next.next = new ListNode(3);
		list2.next.next.next = new ListNode(5);
		list2.next.next.next.next = new ListNode(3);
		list2.next.next.next.next.next = new ListNode(2);
		list2.next.next.next.next.next.next = new ListNode(1);

		// boolean result_1 = isPalindromeLinkedList_Approach1(list1);
		// System.out.println(result_1);
		// boolean result_2 = isPalindromeLinkedList_Approach1(list2);
		// System.out.println(result_2);

		boolean result_3 = isPalindromeLinkedList_Approach2(list1);
		System.out.println(result_3);
		boolean result_4 = isPalindromeLinkedList_Approach2(list2);
		System.out.println(result_4);

	}

	// Simple Approach : Reverse and then compare each element
	public static boolean isPalindromeLinkedList_Approach1(ListNode head) {

		if (head == null) {
			return false;
		}
		ListNode reverseHead = reverseList(head);
		print(reverseHead);
		while (head != null && reverseHead != null) {
			if (head.val != reverseHead.val) {
				return false;
			}
			head = head.next;
			reverseHead = reverseHead.next;
		}
		return true;
	}

	public static ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode prev = null;
		while (current != null) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static boolean isPalindromeLinkedList_Approach2(ListNode head) {

		if (head == null) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		ListNode slow_pointer = head;
		ListNode fast_pointer = head;
		while (fast_pointer != null && fast_pointer.next != null) {
			stack.push(slow_pointer.val);
			slow_pointer = slow_pointer.next;
			fast_pointer = fast_pointer.next.next;
		}
		// If the list size is odd the fast_pointer will not be null; So here we are skipping the middle element
		if (fast_pointer != null) {
			slow_pointer = slow_pointer.next;
		}
		while (slow_pointer != null) {
			int nodeValue = stack.pop();
			if (nodeValue != slow_pointer.val) {
				return false;
			}
			slow_pointer = slow_pointer.next;
		}
		return true;
	}

	public static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

}
