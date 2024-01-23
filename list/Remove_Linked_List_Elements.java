package com.linked.list;

public class Remove_Linked_List_Elements {

    
    
    // https://leetcode.com/problems/remove-linked-list-elements/
    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(7);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(7);
        list.next.next.next.next.next.next = new ListNode(9);

        show(list);
        ListNode result = removeElements(list, 7);
        show(result);

    }

    public static ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head;

        while (node != null && node.next != null) {

            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    
    
    public static void show(ListNode result) {
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println();
    }

}
