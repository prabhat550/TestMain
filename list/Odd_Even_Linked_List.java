package com.linked.list;

public class Odd_Even_Linked_List {

	// https://leetcode.com/problems/odd-even-linked-list/submissions/
	public static void main(String[] args) {

		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);

		show(list);
		ListNode result = oddEvenList(list);
		show(result);

	}

	public static ListNode oddEvenList(ListNode head) {

		if (head == null)
			return null;

		ListNode odd = head;
		ListNode even = head.next;
		ListNode even_head = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = even_head;
		return head;
	}

	public static void show(ListNode result) {
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println();
	}

}
