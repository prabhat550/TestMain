package com.linked.list;

public class Remove_Duplicates_From_Sorted_List_I {

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		node.next = new ListNode(1);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(5);
		node.next.next.next.next = new ListNode(5);

		ListNode result = deleteDuplicates(node);
		show(result);
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		while (node != null && node.next != null) {
			if (node.val == node.next.val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
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
