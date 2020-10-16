package com.tiger.offer.stackAndQueue;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含 min 函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * 作者：画手大鹏
 * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xzqg03/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer30 {
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> stack2;
    private Stack<Integer> stack;

    public Offer30() {
        stack = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (!stack2.isEmpty() && stack2.peek().equals(x)) {
            stack2.peek();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack2.pop();
    }

    public static void main(String[] args){
        Offer30 offer30 = new Offer30();
        offer30.push(-2);
        offer30.push(0);
        offer30.push(-1);
        int min = offer30.min();
        int top1 = offer30.top();
        offer30.pop();
        int min2 = offer30.min();
        System.out.println(min2);

    }
}
