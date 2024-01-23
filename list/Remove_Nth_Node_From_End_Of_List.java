package com.linked.list;

public class Remove_Nth_Node_From_End_Of_List {

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		show(node);
		ListNode result = removeNthFromEnd(node, 2);
		show(result);

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null)
			return head;
		ListNode node = head;
		int size = 1;
		while (node.next != null) {
			node = node.next;
			size++;
		}
		int index = size - n;
		node = head;
		while (index > 1) {
			node = node.next;
			index--;
		}
		node.next = node.next.next;
		return head;
	}

	public static void show(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}

}
