package com.linked.list;

public class Remove_All_Duplicates_From_An_Unsorted_List {

    public static void main(String[] args) {
        
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(3);
        list.next.next.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next.next.next = new ListNode(7);
        list.next.next.next.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next.next.next.next = new ListNode(7);
        
        removeAllDuplicatesUnsortedList(list);

    }
    
    
    public static void removeAllDuplicatesUnsortedList(ListNode head) {

        if (head == null)
            return;

        print(head);
        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

        print(head);

    }
    
    public static void print(ListNode head) {
        
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
        
    }

}
