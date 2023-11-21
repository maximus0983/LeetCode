package leet;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean addOne = false;
        ListNode prev = null;
        ListNode head = l1;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;

            val = (val > 9 ? val % 10 : val) + (addOne ? 1 : 0);
            addOne = l1.val + l2.val > 9;

            l1.val = val;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                int val = l1.val + (addOne ? 1 : 0);
                addOne = val > 9;
                l1.val = addOne ? 0 : val;
                if (addOne && l1.next == null) {
                    l1.next = new ListNode(0);
                }
                l1 = l1.next;

            }
        }
        if (l2 != null) {
            prev.next = l2;
            while (l2 != null) {
                int val = l2.val + (addOne ? 1 : 0);
                addOne = val > 9;
                l2.val = addOne ? 0 : val;
                if (addOne && l2.next == null) {
                    l2.next = new ListNode(0);
                }
                l2 = l2.next;
                prev = l2;
            }
        }
        if (addOne) {
            prev.next = new ListNode(1);
        }

        return head;
    }

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(4);
//        ListNode n3 = new ListNode(3);
//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(6);
//        ListNode l3 = new ListNode(4);
//        n1.next = n2;
//        n2.next = n3;
//        l1.next = l2;
//        l2.next = l3;
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        l1.next = l2;
        l2.next = l3;
        System.out.println(new AddTwoNumbers().addTwoNumbers(n1, l1).val);
    }
}
