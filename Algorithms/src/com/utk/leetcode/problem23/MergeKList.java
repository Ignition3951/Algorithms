package com.utk.leetcode.problem23;

import java.util.PriorityQueue;

public class MergeKList {

    static void main() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = {l1,l2,l3};
        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode list: lists){
            while(list!=null){
                pq.add(list.val);
                list=list.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode temp=head;
        ListNode current=head;
        int size =pq.size();
        for(int i=0;i<size;i++){
            current.next= new ListNode(pq.poll());
            current=current.next;
        }
        temp=temp.next;
        return temp;
    }
}
