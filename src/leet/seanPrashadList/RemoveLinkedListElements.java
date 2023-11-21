package leet.seanPrashadList;

import leet.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            head = removeElements(head.next, val);
        } else head.next = removeElements(head.next, val);
        return head;
    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(7);
        ListNode n5 = new ListNode(4, n6);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(7, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode listNode = new RemoveLinkedListElements().removeElements(n1, 7);
    }
}
