


/*


Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.



*/



import java.util.*;
class ListNode {
    int value = 0;
    ListNode next;
    ListNode(int value) {
        this.value = value;
    }
}
class RotateList {
    public static ListNode rotate(ListNode head, int rotations) {
        if (head == null || head.next == null || rotations <= 0)
            return head;
        ListNode lastNode = head;
        int length = 1;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            length++;
        }
        lastNode.next = head;
        rotations %= length;
        int skiplength = length - rotations;
        ListNode LastNodeOfList = head;
        for (int i = 0; i < skiplength - 1; i++)
            LastNodeOfList = LastNodeOfList.next;
        head = LastNodeOfList.next;
        LastNodeOfList.next = null;
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
