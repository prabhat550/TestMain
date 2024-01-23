package com.linked.list;
public class Remove_Middle_Element {

    public static void main(String[] args) {
        
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next = new ListNode(7);
        
        removeMiddleElement(list);

    }
    
    // Given access to the head node of the list
    public static void removeMiddleElement(ListNode head) {
        
        if(head == null) {
            return;
        }
        
        printElements(head);
        ListNode slow_pointer = head;
        ListNode fast_pointer = head;
        
        // Get access to the middle element
        while(fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
        }
        System.out.println(slow_pointer.val);
        
        slow_pointer.val = slow_pointer.next.val;
        slow_pointer.next = slow_pointer.next.next;
        
        printElements(head);
    }
    
    public static void printElements(ListNode head) {
        
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    

}
