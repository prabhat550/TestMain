package com.linked.list;

import java.util.HashMap;
import java.util.Map;

public class Linked_List_Cycle_II {

    public static void main(String[] args) {

        ListNode node = new ListNode(3);
        node.next = new ListNode(5);
        node.next.next = new ListNode(7);
        node.next.next.next = new ListNode(9);
        node.next.next.next.next = new ListNode(11);
        node.next.next.next.next.next = node.next.next;

        ListNode result_1 = detectCycle_Approach_1(node);
        System.out.println(result_1.val);

        ListNode result_2 = detectCycle_Approach_2(node);
        System.out.println(result_2.val);

    }

    // Using HashMap
    public static ListNode detectCycle_Approach_1(ListNode head) {

        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, head.val);
            } else {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    // Equation D = (i-2j) - K
    // Floyd Cycle Detection
    public static ListNode detectCycle_Approach_2(ListNode head) {

        ListNode slow_pointer = head;
        ListNode fast_pointer = head;
        boolean linkedListIsCyclic = false;

        while (fast_pointer != null && fast_pointer.next != null) {

            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;

            if (slow_pointer == fast_pointer) {
                linkedListIsCyclic = true;
                break;
            }
            
        }

        if (linkedListIsCyclic) {
            ListNode head_pointer = head;
            while (head_pointer != slow_pointer) {
                slow_pointer = slow_pointer.next;
                head_pointer = head_pointer.next;
            }

            return slow_pointer;

        }
        return null;
    }

}
