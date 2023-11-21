package leet;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if (fast != null) {
            current = current.next;
        }
        while (current != null) {
            if (current.val != prev.val) {
                return false;
            } else {
                current = current.next;
                prev = prev.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode q5 = new ListNode(1);
        ListNode q4 = new ListNode(2, q5);
        ListNode q3 = new ListNode(2, q4);
        ListNode q2 = new ListNode(2, q3);
        ListNode q1 = new ListNode(1, q2);
        new PalindromeLinkedList().isPalindrome(q1);
    }
}
