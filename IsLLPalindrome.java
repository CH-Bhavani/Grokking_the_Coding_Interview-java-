/*

Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.

Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. The algorithm should have
O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
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
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(2);
            System.out.println("Is palindrome: " + isPalindrome(head));
            head.next.next.next.next.next = new ListNode(2);
            System.out.println("Is palindrome: " +isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head){
        if(head==null || head.next==null)
            return true;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       // ;   System.out.println(slow.data)
        ListNode secondhalf=reverse(slow);
        ListNode copysecondHalf=secondhalf;
        while(head!=null && secondhalf!=null){
            if(head.data !=secondhalf.data) {
                break;
            }
            head=head.next;
            secondhalf=secondhalf.next;
        }
        reverse(copysecondHalf);
        if(head==null && secondhalf ==null)
            return  true;
        return false;
        }
        public static ListNode reverse(ListNode head){
            ListNode prev=null;
            while(head!=null){
                ListNode next=head.next;
                head.next=prev;
                prev=head;
                head=next;
            }
            return prev;
        }
    }

