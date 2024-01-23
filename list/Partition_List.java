package com.linked.list;

public class Partition_List {

    // https://leetcode.com/problems/partition-list/
    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.next = new ListNode(3);
        list.next.next = new ListNode(8);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(3);
        list.next.next.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next.next.next = new ListNode(7);
        list.next.next.next.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next.next.next.next = new ListNode(7);

        partition(list, 5);

    }

    // 1 -> 3 -> 8 -> 4 -> 5 -> 3 -> 4 -> 7 -> 6 -> 7 ->
    public static ListNode partition(ListNode head, int x) {
        
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;
        
        while(head != null) {
            
            if(head.val < x) {
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;
        
        print(before_head.next);
        return before_head.next;

    }

    public static void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

    }

}
