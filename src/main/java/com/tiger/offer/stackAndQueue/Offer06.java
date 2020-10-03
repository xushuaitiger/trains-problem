package com.tiger.offer.stackAndQueue;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Offer06 {

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode pointer = head;
        while (pointer != null) {
            stack.push(pointer);
            pointer = pointer.next;
        }
        int length = stack.size();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

}
 class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
 }