package com.linked.list;

public class Swapping_Nodes_In_A_Linked_List {

    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        printList(list);
        ListNode result = swapNodes(list, 2);
        printList(result);

    }

    public static ListNode swapNodes(ListNode head, int k) {

        if (head == null)
            return null;
        k = k - 1;
        ListNode first_Node = head;
        ListNode second_Node = head;

        while (k > 0) {
            first_Node = first_Node.next;
            k--;
        }
        
        ListNode first_Node_Reference = first_Node;
        while (first_Node.next != null) {
            first_Node = first_Node.next;
            second_Node = second_Node.next;
        }

        int temp_Value = first_Node_Reference.val;
        first_Node_Reference.val = second_Node.val;
        second_Node.val = temp_Value;

        return head;

    }

    public static void printList(ListNode head) {

        System.out.print(head.val + " ");
        
        while (head.next != null) {
            head = head.next;
            System.out.print(head.val + " ");
        }
        
        System.out.println();
    }

}
