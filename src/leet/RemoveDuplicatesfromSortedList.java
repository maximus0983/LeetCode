package leet;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        while (next != null && next.val == head.val) {
            head.next = next.next;
            next = next.next;
        }
        deleteDuplicates(next);

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new RemoveDuplicatesfromSortedList().deleteDuplicates(
                new ListNode(1, new ListNode(1, new ListNode(1, null)))
        );
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
