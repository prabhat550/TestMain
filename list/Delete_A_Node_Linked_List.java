package com.linked.list;

public class Delete_A_Node_Linked_List {

	// https://leetcode.com/problems/delete-node-in-a-linked-list/
	public static void main(String[] args) {

		ListNode n1 = new ListNode(3);
		n1.next = new ListNode(5);
		n1.next.next = new ListNode(7);
		n1.next.next.next = new ListNode(9);
		n1.next.next.next.next = new ListNode(11);
		show(n1);
		deleteNode(n1.next);
		show(n1);
	}
	
	// Taking Value Of The Next Node And Change Reference OfThe Next Node To Next Next Node
	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void show(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}

}
