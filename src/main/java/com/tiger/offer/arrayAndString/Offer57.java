package com.tiger.offer.arrayAndString;

/**
 * 剑指 Offer 57. 和为 s 的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 作者：画手大鹏
 * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xzimqj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum < target) {
                start++;
            } else if(sum > target) {
                end--;
            } else {
                return new int[] { nums[start], nums[end] };
            }
        }
        return new int[0];
    }


}
