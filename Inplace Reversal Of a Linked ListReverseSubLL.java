/*

Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

*/




class ListNode {
    int value = 0;
    Node next;
    ListNode(int value) {
        this.value = value;
    }
}
public class ReverseSubList {
    public static Node reverse(Node head, int p, int q) {
        Node current=head,previous=null;
        for(int i=0;current!=null && i<p-1;i++) {
            previous=current;
            current=current.next;
        }
        Node lastNodeOfFirstpart=previous;
        Node lastNodeOfSubList =current;
        Node next=null;
        for(int i=0;current!=null && i<q-p+1;i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        if(lastNodeOfFirstpart!=null)
            lastNodeOfFirstpart.next=previous;
        else
            head=previous;
        lastNodeOfSubList.next=current;
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
