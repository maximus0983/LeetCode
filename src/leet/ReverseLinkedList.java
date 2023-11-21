package leet;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head.next;
        ListNode next = current.next;
        current.next = head;
        head.next = null;
        head = current;
        while (next != null) {
            ListNode prev = current;
            current = next;
            next = current.next;
            current.next = prev;
                head = current;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode q5 = new ListNode(5);
        ListNode q4 = new ListNode(4, q5);
        ListNode q3 = new ListNode(3, q4);
        ListNode q2 = new ListNode(2, q3);
        ListNode q1 = new ListNode(1, q2);
        ListNode listNode = new ReverseLinkedList().reverseList(q4);
    }
}
