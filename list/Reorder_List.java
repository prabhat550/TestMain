package com.linked.list;

public class Reorder_List {

    
    
    // https://leetcode.com/problems/reorder-list/
    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        

        show(list);
        ListNode result = reorderList(list);
        show(result);

    }

    public static ListNode reorderList(ListNode head) {

        // head of the first list
        ListNode l1 = head;
        // head of the second list
        ListNode slow_pointer = head;

        // tail of the second list
        ListNode fast_pointer = head;
        // tail of the first list
        ListNode prev = null;

        while (fast_pointer != null && fast_pointer.next != null) {
            
            prev = slow_pointer;
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            
        }

        prev.next = null;
        
        ListNode l2 = reverseList(slow_pointer);
        
        merge(l1, l2);

        return l1;

    }

    public static void merge(ListNode l1, ListNode l2) {

        while (l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            l1.next = l2;
            if (l1_next == null)
                break;

            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }

    }

    public static ListNode reverseList(ListNode root) {

        ListNode current = root;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void show(ListNode result) {

        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println();
    }

}
