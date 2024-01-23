package com.linked.list;

public class Reverse_Linked_List_II {

    // https://leetcode.com/problems/reverse-linked-list-ii/
    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        print(node);
        ListNode result = reverseBetween(node, 2, 4);
        print(result);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) {
            return null;
        }
        ListNode current_node = head;
        ListNode prev = null;
        while (left > 1) {
            prev = current_node;
            current_node = current_node.next;
            left--;
            right--;
        }
        ListNode connection = prev;
        ListNode tail = current_node;
        while (right > 0) {
            ListNode next = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = next;
            right--;
        }

        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }
        tail.next = current_node;

        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

}
