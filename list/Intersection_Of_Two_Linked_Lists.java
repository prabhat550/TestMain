package com.linked.list;

public class Intersection_Of_Two_Linked_Lists {

	// https://leetcode.com/problems/intersection-of-two-linked-lists/
	public static void main(String[] args) {

		ListNode n1 = new ListNode(3);
		n1.next = new ListNode(5);
		n1.next.next = new ListNode(12);
		n1.next.next.next = new ListNode(9);
		n1.next.next.next.next = new ListNode(11);
		show(n1);

		ListNode n2 = new ListNode(2);
		n2.next = n1.next.next;
		show(n2);

		ListNode result_1 = getIntersectionNode_Approach1(n1, n2);
		System.out.println(result_1.val);

		ListNode result_2 = getIntersectionNode_Approach2(n1, n2);
		System.out.println(result_2.val);

	}

	public static ListNode getIntersectionNode_Approach1(ListNode headA, ListNode headB) {

		if (headA == null || headB == null)
			return null;

		ListNode a_pointer = headA;
		ListNode b_pointer = headB;

		while (a_pointer != b_pointer) {
			if (a_pointer == null) {
				a_pointer = headB;
			} else { 
				a_pointer = a_pointer.next;
			}
			if (b_pointer == null) {
				b_pointer = headA;
			} else {
				b_pointer = b_pointer.next;
			}
		}
		return a_pointer;
	}

	public static ListNode getIntersectionNode_Approach2(ListNode headA, ListNode headB) {

		int sizeA = getSize(headA);
		int sizeB = getSize(headB);

		if (sizeA > sizeB) {
			int difference = sizeA - sizeB;
			while (difference != 0) {
				headA = headA.next;
				difference--;
			}
		} else {
			int difference = sizeB - sizeA;
			while (difference != 0) {
				headB = headB.next;
				difference--;
			}
		}
		ListNode a_pointer = headA;
		ListNode b_pointer = headB;
		while (a_pointer != b_pointer) {
			a_pointer = a_pointer.next;
			b_pointer = b_pointer.next;
		}

		return a_pointer;
	}

	public static int getSize(ListNode head) {
		int resultSize = 0;
		while (head != null) {
			head = head.next;
			resultSize += 1;
		}
		return resultSize;
	}

	public static void show(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}

}
