package com.linked.list;

import java.util.HashMap;

public class Linked_List_Cycle {

    // https://leetcode.com/problems/linked-list-cycle/
    public static void main(String[] args) {

        ListNode node = new ListNode(3);
        node.next = new ListNode(0);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = node.next.next;

        boolean result_1 = hasCycle_Approach1(node);
        System.out.println(result_1);

        boolean result_2 = hasCycle_Approach2(node);
        System.out.println(result_2);

    }

    // Floyd’s Cycle Detection Algorithm
    public static boolean hasCycle_Approach1(ListNode head) {

        if (head == null)
            return false;

        ListNode slow_pointer = head;
        ListNode fast_pointer = head;

        while (fast_pointer != null && fast_pointer.next != null) {

            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;

            if (slow_pointer == fast_pointer) {
                System.out.println(slow_pointer.val + "  " + fast_pointer.val);
                return true;
            }

        }
        return false;
    }

    public static boolean hasCycle_Approach2(ListNode head) {

        HashMap<ListNode, Integer> map = new HashMap<>();

        while (head != null) {

            if (!map.containsKey(head)) {
                map.put(head, head.val);
            } else {
                return true;
            }
            head = head.next;

        }

        return false;

    }

}
