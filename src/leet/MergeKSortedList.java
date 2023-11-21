package leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> l = new ArrayList();
        for (int i=0; i<lists.length; i++){
            createList(l, lists[i]);
        }
        l.sort(Comparator.comparingInt(o -> o.val));
        mergeSort(l);
        createLN(l);
        return l.get(0);
    }

    void createLN(List<ListNode> l){
        ListNode head = l.get(0);
        for(int i=1;i<l.size();i++){
            head.next = l.get(i);
            head = l.get(i);
        }
    }

    void createList(List<ListNode> l, ListNode node){
        while(node!=null){
            l.add(node);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode[] l1 = {n1, n2, n3};
        new MergeKSortedList().mergeKLists(l1);
    }



    List<ListNode> createList(ListNode node){
        List<ListNode> res = new ArrayList();
        while(node!=null){
            res.add(node);
            node = node.next;
        }
        return res;
    }

    void mergeSort(List<ListNode> list){
//        System.out.println(list.get(0).val);
        list.forEach(n->System.out.print(n.val));
        sort(list, 0, list.size()-1);
    }

    void sort(List<ListNode> list, int left, int right){
        if(left<right){
            int m = left + (right - left)/2;
            // System.out.println(left+" "+m+" "+right);
            sort(list, left, m);
            sort(list, m+1, right);

            merge(list, left, m, right);
        }
    }

    void merge(List<ListNode> list, int left, int mid, int right){
        int leftSize = mid - left +1;
        int rightSize = right - mid;
        // System.out.println(left+" "+mid+" "+right);
        ListNode[] leftArr = new ListNode[leftSize];
        ListNode[] rightArr = new ListNode[rightSize];

        for(int i=0; i<leftSize;i++){
            leftArr[i] = list.get(left+i);
        }
        for(int i=0; i<rightSize;i++){
            rightArr[i] = list.get(mid+1+i);
        }

        int k = left;
        int i = 0;
        int j = 0;
        while(i < leftSize&& j < rightSize){
            if(leftArr[i].val<=rightArr[j].val){
                list.set(k, leftArr[i]);
                i++;
            }else{
                list.set(k, rightArr[j]);
                j++;
            }
            k++;
        }

        while(i<leftSize){
            list.set(k, leftArr[i]);
            k++;
            i++;
        }

        while(j<rightSize){
            list.set(k, rightArr[j]);
            k++;
            j++;
        }
    }
}
