/*

Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.

Your algorithm should not use any extra space and the input LinkedList should be modified in-place.

Example 1:

Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null 
Example 2:

Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
*/

import java.util.*;
public class test{
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
        static ListNode head;
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next= new ListNode(14);
        head.next.next.next.next.next .next.next= new ListNode(16);
        reorder(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        }
        public static void reorder(ListNode head){
            if(head==null && head.next==null)
                return;
            ListNode slow=head,fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode headsecondHalf=reverse(slow);
            ListNode headfirstHalf=head;
            while (headfirstHalf!=null &&headsecondHalf!=null){
                ListNode temp=headfirstHalf.next;
                headfirstHalf.next=headsecondHalf;
                headfirstHalf=temp;
                temp=headsecondHalf.next;
                headsecondHalf.next=headfirstHalf;
                headsecondHalf=temp;
            }
            if(headfirstHalf!=null)
                headfirstHalf.next=null;
        }
        public static ListNode reverse(ListNode head){
        ListNode prev=null,next=head;
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
        }
    }


