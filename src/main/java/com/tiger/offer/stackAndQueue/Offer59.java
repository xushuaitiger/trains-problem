package com.tiger.offer.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int right = 0, left = 1 - k; right < nums.length; left++, right++) {
            if(left > 0 && queue.peekFirst() == nums[left - 1]) {
                queue.removeFirst();
            }
            while(!queue.isEmpty() && queue.peekLast() < nums[right]) {
                queue.removeLast();
            }
            queue.addLast(nums[right]);
            if(left >= 0) {
                res[left] = queue.peekFirst();
            }
        }
        return res;
    }

   public static void main(String[] args){
        Offer59 offer = new Offer59();
        int[] test = {1,3,-1,-3,5,3,6,7};
        int[] result =offer.maxSlidingWindow(test,3);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

   }
}
