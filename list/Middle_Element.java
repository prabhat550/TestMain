package com.linked.list;

public class Middle_Element {

	public static void main(String[] args) {

		ListNode node = new ListNode(3);
		node.next = new ListNode(5);
		node.next.next = new ListNode(7);
		node.next.next.next = new ListNode(9);
		node.next.next.next.next = new ListNode(11);

		ListNode result = middleNode(node);
		System.out.println(result.val);

	}

	public static ListNode middleNode(ListNode node) {
		ListNode slow_pointer = node;
		ListNode fast_pointer = node;
		while (fast_pointer != null && fast_pointer.next != null) {
			slow_pointer = slow_pointer.next;
			fast_pointer = fast_pointer.next.next;
		}
		return slow_pointer;
	}

	public static void show(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}

}
