package com.linked.list;

public class Insertion_Sort_List {

	public static void main(String[] args) {

		ListNode node = new ListNode(4);
		node.next = new ListNode(2);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(3);
		
		ListNode result_insertionSortList = insertionSortList(node);
		show(result_insertionSortList);

	}

	public static ListNode insertionSortList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode dummy_node = new ListNode(-1);
		dummy_node.next = head;
		ListNode curr = head, prev = dummy_node;

		while (curr != null) {

			if (curr.next != null && curr.next.val < curr.val) {
				while (prev.next != null && prev.next.val < curr.next.val) {
					prev = prev.next;
				}
				ListNode temp = prev.next;
				prev.next = curr.next;
				curr.next = curr.next.next;
				prev.next.next = temp;
				prev = dummy_node;
			} else {
				curr = curr.next;
			}
		}

		return dummy_node.next;
	}

	public static void show(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

}
