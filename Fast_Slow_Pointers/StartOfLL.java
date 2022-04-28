//Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.


class ListNode {
    int value = 0;
    ListNode next;
    ListNode(int value) {
        this.value = value;
    }
}
public class cycle {
    public static int findCycle(ListNode head){
        ListNode slow=head,fast=head;
        int l=0;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                l = calculateLength(slow);
                break;
            }
        }
        return findStartOfCycle(head,l);
    }
    public static int calculateLength(ListNode slow){
        ListNode current=slow;
        int length=0;
        do{
            current=current.next;
            length++;
        }
        while(current!=slow);
        return length;
    }
    public static int findStartOfCycle(ListNode head ,int l){
        ListNode pointer1=head,pointer2=head;
        while(l>0){
            pointer2=pointer2.next;
            l--;
        }
        while(pointer1!=pointer2){
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }
        return pointer1.value;
    }
    public static  void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + findCycle(head));
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + findCycle(head));
        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList has cycle: " + findCycle(head));
    }
}

