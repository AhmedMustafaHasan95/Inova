
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MiddleNode {
    public ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        MiddleNode middleNodeFinder = new MiddleNode();
        System.out.println(middleNodeFinder.findMiddleNode(head1).val);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);

        System.out.println(middleNodeFinder.findMiddleNode(head2).val);
    }
}
/*
*
* Time Complexity: O(n) - where n is the number of nodes in the linked list. The algorithm uses two pointers to traverse the list, and the fast pointer moves twice as fast as the slow pointer.
*
* */

