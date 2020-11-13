package com.tiger.offer2;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 难度 EASY
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length<1) return 0;
        int start =0;
        int end =nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) start = ++mid;
            else end = --mid;
        }
        return start;
    }

}
