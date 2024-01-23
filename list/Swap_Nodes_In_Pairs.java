package com.linked.list;


public class Swap_Nodes_In_Pairs {

    
    // https://leetcode.com/problems/swap-nodes-in-pairs/
    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        
        
        show(list);
        ListNode result = swapPairs(list);
        show(result);

    }

    
   
    public static ListNode swapPairs(ListNode head) {
        
        if(head == null)
            return null;
        
        ListNode temp = head;
        int k = 0;
        while(temp !=null && temp.next !=null) {
            k = temp.val;
            temp.val = temp.next.val;
            temp.next.val = k;
            temp = temp.next.next;
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
