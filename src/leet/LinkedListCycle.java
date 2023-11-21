package leet;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean exitFromLoop = false;
        while (fast != null && fast.next != null && !exitFromLoop) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
            if (fast == null) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode q5 = new ListNode(5);
        ListNode q4 = new ListNode(4);
        ListNode q3 = new ListNode(3, q4);
        ListNode q2 = new ListNode(2, q3);
        ListNode q1 = new ListNode(1, q2);
        q4.next = q2;
        System.out.println(new LinkedListCycle().hasCycle(q1));
    }
}
