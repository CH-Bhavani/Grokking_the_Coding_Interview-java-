







//Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.class ListNode 


class ListNode {
    int value = 0;
    ListNode next;
    ListNode(int value) {
        this.value = value;
    }
}
public class cycle {
    public static boolean findCycle(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
    public static  void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + findCycle(head));
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + findCycle(head));
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + findCycle(head));
    }
}

