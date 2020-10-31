package com.tiger.offer.linkedlist;

public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head, post = head;

        for(int i = 0; i < k; i++) {
            pre = pre.next;
        }
        while(pre != null) {
            pre = pre.next;
            post = post.next;
        }
        return post;
    }

     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


}
