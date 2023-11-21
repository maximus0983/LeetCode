package leet;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (i++ < n) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        if (next != null) {
            slow.next = next.next;
        } else slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode q5 = new ListNode(5);
        ListNode q4 = new ListNode(4,q5);
        ListNode q3 = new ListNode(3,q4);
        ListNode q2 = new ListNode(2,q3);
        ListNode q1 = new ListNode(1,q2);
        ListNode listNode = new RemoveNthNodeFromEndofList().removeNthFromEnd(q1, 2);
    }
}
