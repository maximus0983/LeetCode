package leet;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode les;
        ListNode big;
        if (list1 != null && list2 != null) {
            les = list1.val < list2.val ? list1 : list2;
            big = list1.val < list2.val ? list2 : list1;
            list1 = les;
            list1.next = mergeTwoLists(big, les.next);
        } else if (list1 == null) {
            return list2;
        } else {
            return list1;
        }
        return list1;
    }

    public static void main(String[] args) {
//        ListNode listNode = new MergeTwoSortedLists().mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(3, null))),
//                new ListNode(1, new ListNode(2, new ListNode(3, null))));
        ListNode listNode = new MergeTwoSortedLists().mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(3, null))),
                new ListNode());
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}


