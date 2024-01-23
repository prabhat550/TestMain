package com.linked.list;

public class Rotate_List {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        printList(node);
        ListNode result = rotateRight(node, 2);
        printList(result);

    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // Get the length of the linked list
        ListNode current_node = head;
        ListNode prev = null;
        int size = 0;
        
        while (current_node != null) {
            prev = current_node;
            current_node = current_node.next;
            size++;
        }
        
        prev.next = head;
        k = k % size;
        k = size - k;
       
        while (k > 0) {
            prev = prev.next;
            k--;
        }
        head = prev.next;
        prev.next = null;

        return head;

    }

    public static void printList(ListNode root) {

        while (root != null) {
            System.out.print(root.val + "->");
            root = root.next;
        }
        System.out.println();

    }

}
