package com.tiger.offer2.arrayandlinkedlist;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
       if(head ==null){
           return null;
       }
       ListNode odd = head; //奇指针
       ListNode even = head.next;//偶指针
       ListNode evenHead = even; //偶链表头指针
       while(even !=null && even.next !=null){
           odd.next =even.next; //偶数链表下个元素赋值给奇数下一个
           odd = odd.next;      //奇指针指向自己下一个
           even.next = odd.next;
           even = even.next;
       }
       odd.next = evenHead;

        ListNode tem = head;
        StringBuilder re = new StringBuilder(tem.val + "->");
        while (tem.next != null) {
            re.append(tem.next.val + "->");
            tem = tem.next;
        }
        System.out.println(re.substring(0,re.length()-2));
       return head;
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
        new OddEvenList().oddEvenList(head);
    }
    static class ListNode {
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
