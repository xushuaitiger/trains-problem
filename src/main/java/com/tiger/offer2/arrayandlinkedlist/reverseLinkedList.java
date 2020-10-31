package com.tiger.offer2.arrayandlinkedlist;

public class reverseLinkedList {
    private ListNode reverse(ListNode head) {
        //每次遍历用到的上一个节点
        ListNode pre = null;
        //次遍历用到的当前节点
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            ListNode next = curr.next;//保留当前节点的下一个节点
            curr.next = pre;//下一个节点指向当前节点的上个节点
            pre = curr;//下次边里用到的上一个节点（当前遍历时为当前节点）
            curr = next;//下次遍历需要用到的当前节点（当前遍历时是下一个节点）
            //输出测试
            System.out.println("the " + i + " time :");
            ListNode tem = pre;
            StringBuilder re = new StringBuilder("the " + i + " time: " + tem.val + "->");
            while (tem.next != null) {
                re.append(tem.next.val + "->");
                tem = tem.next;
            }
            System.out.println(re.substring(0,re.length()-2));
        }
        //整个循环结束，实际上pre即是反转后的链表
        return pre;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2, new ListNode(3, null));
        ListNode head = new ListNode(1, node2);
        new reverseLinkedList().reverse(head);
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
