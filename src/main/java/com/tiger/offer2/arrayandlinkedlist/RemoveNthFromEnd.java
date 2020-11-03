package com.tiger.offer2.arrayandlinkedlist;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2, new ListNode(3, null));
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node5.next= node6;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode head = new ListNode(1, node2);
        int i = 1+2*4-5/2;
        new RemoveNthFromEnd().removeNthFromEnd(head,3);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
