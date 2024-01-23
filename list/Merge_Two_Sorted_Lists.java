package com.linked.list;

public class Merge_Two_Sorted_Lists {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(3);
		n1.next = new ListNode(5);
		n1.next.next = new ListNode(7);
		n1.next.next.next = new ListNode(9);
		n1.next.next.next.next = new ListNode(11);
		show(n1);

		ListNode n2 = new ListNode(2);
		n2.next = new ListNode(4);
		n2.next.next = new ListNode(6);
		n2.next.next.next = new ListNode(8);
		n2.next.next.next.next = new ListNode(10);
		show(n2);

		ListNode result = mergeTwoLists(n1, n2);
		show(result);

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr_node = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				curr_node.next = l1;
				l1 = l1.next;
			} else {
				curr_node.next = l2;
				l2 = l2.next;
			}
			curr_node = curr_node.next;
		}
		if (l1 != null)
			curr_node = l1;
		if (l2 != null)
			curr_node = l2;
		return dummy.next;
	}

	public static void show(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}

}
